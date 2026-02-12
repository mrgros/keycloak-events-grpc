package ru.event.listener.extension;

import lombok.extern.slf4j.Slf4j;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.events.admin.OperationType;
import org.keycloak.events.admin.ResourceType;
import com.keycloak.event.v1.EventAPIGrpc;
import io.grpc.ManagedChannel;

import static ru.event.listener.extension.EventUtils.toCreateAdminRequest;
import static ru.event.listener.extension.EventUtils.toCreateRequest;

@Slf4j
public class GrpcEventListenerProvider implements EventListenerProvider {
    private final EventAPIGrpc.EventAPIBlockingStub eventApiStub;
    private final ManagedChannel channel;

    public GrpcEventListenerProvider(EventAPIGrpc.EventAPIBlockingStub eventApiStub, ManagedChannel channel) {
        this.eventApiStub = eventApiStub;
        this.channel = channel;
    }

    @Override
    public void onEvent(Event event) {
        try {
            eventApiStub.create(toCreateRequest(event));
        } catch (Exception e) {
            log.error("Failed to send event to gRPC server", e);
        }
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
        try {
            eventApiStub.createAdmin(toCreateAdminRequest(adminEvent));
        } catch (Exception e) {
            log.error("Failed to send admin event to gRPC server", e);
        }
    }

    @Override
    public void close() {
        if (channel != null && !channel.isShutdown()) {
            channel.shutdown();
        }
    }
}