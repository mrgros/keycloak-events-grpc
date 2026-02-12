package ru.event.listener.extension;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.Config;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.EventListenerProviderFactory;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import com.keycloak.event.v1.EventAPIGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

@Slf4j
public class GrpcEventListenerProviderFactory implements EventListenerProviderFactory {
    private static final String LISTENER_ID = "grpc-event-listener";
    private static final String CONFIG_HOST = "GRPC_HOST";
    private static final String CONFIG_PORT = "GRPC_PORT";
    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 9090;

    private String host;
    private int port;
    private volatile ManagedChannel channel;

    @Override
    public EventListenerProvider create(KeycloakSession session) {
        if (channel == null || channel.isShutdown()) {
            synchronized (this) {
                if (channel == null || channel.isShutdown()) {
                    try {
                        channel = ManagedChannelBuilder.forAddress(host, port)
                                .usePlaintext()
                                .build();
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to create gRPC channel", e);
                    }
                }
            }
        }

        EventAPIGrpc.EventAPIBlockingStub stub = EventAPIGrpc.newBlockingStub(channel);
        return new GrpcEventListenerProvider(stub, channel);
    }

    @Override
    public void init(Config.Scope scope) {
        String hostEnv = System.getenv(CONFIG_HOST);
        this.host = (hostEnv != null && !hostEnv.isEmpty()) ? hostEnv : DEFAULT_HOST;

        String portStr = System.getenv(CONFIG_PORT);
        if (portStr != null && !portStr.isEmpty()) {
            try {
                this.port = Integer.parseInt(portStr);
            } catch (NumberFormatException e) {
                log.warn("Invalid port value: {}, using default: {}", portStr, DEFAULT_PORT);
                this.port = DEFAULT_PORT;
            }
        } else {
            this.port = DEFAULT_PORT;
        }

        log.info("gRPC listener initialized with host: {}, port: {}", this.host, this.port);
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) {

    }

    @Override
    public void close() {
        if (channel != null && !channel.isShutdown()) {
            try {
                channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override
    public String getId() {
        return LISTENER_ID;
    }
}