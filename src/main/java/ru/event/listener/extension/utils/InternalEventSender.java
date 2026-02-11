package ru.event.listener.extension.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.keycloak.events.Event;

@Slf4j
public class InternalEventSender {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void send(Event body, String url) {
        log.info("Sending data {} to URL {}", body, url);

        String jsonRequestBody;
        try {
            jsonRequestBody = objectMapper.writeValueAsString(body);
        } catch (JsonProcessingException e) {
            log.error("Failed to create json string");
            return;
        }
        send(jsonRequestBody, url);
    }

    private void send(String json, String url) {
        HttpRequest request = HttpRequest
                .newBuilder(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        log.info("Sending data to url {}", request);

        HttpClient client = HttpClient.newHttpClient();
        try {
            client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            log.error("Failed to send request to user-service {}", request);
        }
    }
}
