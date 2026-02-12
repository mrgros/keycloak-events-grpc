package ru.event.listener.extension;

import com.keycloak.event.v1.CreateAdminRequest;
import com.keycloak.event.v1.CreateRequest;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.events.Event;
import org.keycloak.events.admin.AdminEvent;
import org.keycloak.events.admin.AuthDetails;
import org.keycloak.events.admin.OperationType;
import org.keycloak.events.admin.ResourceType;

@Slf4j
public class EventUtils {
    private static com.keycloak.event.v1.EventType convertEventType(org.keycloak.events.EventType eventType) {
        if (eventType == null) {
            return com.keycloak.event.v1.EventType.EVENT_TYPE_INVALID;
        }

        String protoName = "EVENT_TYPE_" + eventType.name();
        try {
            return com.keycloak.event.v1.EventType.valueOf(protoName);
        } catch (IllegalArgumentException e) {
            log.warn("Unknown event type: {}, returning INVALID", eventType.name());
            return com.keycloak.event.v1.EventType.EVENT_TYPE_INVALID;
        }
    }

    private static String convertResourceType(ResourceType resourceType) {
        if (resourceType == null) {
            return "";
        }

        return resourceType.name();
    }

    private static com.keycloak.event.v1.OperationType convertOperationType(OperationType operationType) {
        if (operationType == null) {
            return com.keycloak.event.v1.OperationType.OPERATION_TYPE_INVALID;
        }

        String protoName = "OPERATION_TYPE_" + operationType.name();
        try {
            return com.keycloak.event.v1.OperationType.valueOf(protoName);
        } catch (IllegalArgumentException e) {
            log.warn("Unknown operation type: {}, returning INVALID", operationType.name());
            return com.keycloak.event.v1.OperationType.OPERATION_TYPE_INVALID;
        }
    }

    public static CreateRequest toCreateRequest(Event event) {
        com.keycloak.event.v1.CreateRequest.Builder requestBuilder = com.keycloak.event.v1.CreateRequest.newBuilder()
                .setId(event.getId())
                .setTime(com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(event.getTime() / 1000)
                        .setNanos((int) ((event.getTime() % 1000) * 1000000))
                        .build())
                .setType(convertEventType(event.getType()));

        if (event.getRealmId() != null) {
            requestBuilder.setRealmId(event.getRealmId());
        }
        if (event.getRealmName() != null) {
            requestBuilder.setRealmName(event.getRealmName());
        }
        if (event.getUserId() != null) {
            requestBuilder.setUserId(event.getUserId());
        }
        if (event.getSessionId() != null) {
            requestBuilder.setSessionId(event.getSessionId());
        }
        if (event.getIpAddress() != null) {
            requestBuilder.setIpAddress(event.getIpAddress());
        }
        if (event.getError() != null) {
            requestBuilder.setError(event.getError());
        }
        if (event.getDetails() != null) {
            event.getDetails().forEach((key, value) -> {
                requestBuilder.putDetails(key, value != null ? value : "");
            });
        }
        if (event.getClientId() != null) {
            requestBuilder.setClientId(event.getClientId());
        }

        return requestBuilder.build();
    }

    public static CreateAdminRequest toCreateAdminRequest(AdminEvent adminEvent) {
        com.keycloak.event.v1.CreateAdminRequest.Builder requestBuilder = com.keycloak.event.v1.CreateAdminRequest.newBuilder()
                .setId(adminEvent.getId())
                .setTime(com.google.protobuf.Timestamp.newBuilder()
                        .setSeconds(adminEvent.getTime() / 1000)
                        .setNanos((int) ((adminEvent.getTime() % 1000) * 1000000))
                        .build());

        if (adminEvent.getRealmId() != null) {
            requestBuilder.setRealmId(adminEvent.getRealmId());
        }
        if (adminEvent.getRealmName() != null) {
            requestBuilder.setRealmName(adminEvent.getRealmName());
        }
        if (adminEvent.getAuthDetails() != null) {
            requestBuilder.setAuthDetails(toAuthDetails(adminEvent.getAuthDetails()));
        }
        if (adminEvent.getResourceType() != null) {
            requestBuilder.setResourceType(convertResourceType(adminEvent.getResourceType()));
        }
        if (adminEvent.getOperationType() != null) {
            requestBuilder.setOperationType(convertOperationType(adminEvent.getOperationType()));
        }
        if (adminEvent.getResourcePath() != null) {
            requestBuilder.setResourcePath(adminEvent.getResourcePath());
        }
        if (adminEvent.getError() != null) {
            requestBuilder.setError(adminEvent.getError());
        }
        if (adminEvent.getDetails() != null) {
            adminEvent.getDetails().forEach((key, value) -> {
                requestBuilder.putDetails(key, value != null ? value : "");
            });
        }
        if (adminEvent.getRepresentation() != null) {
            requestBuilder.setRepresentation(adminEvent.getRepresentation());
        }

        return requestBuilder.build();
    }

    public static CreateAdminRequest.AuthDetails toAuthDetails(AuthDetails authDetails) {
        CreateAdminRequest.AuthDetails.Builder authBuilder = com.keycloak.event.v1.CreateAdminRequest.AuthDetails.newBuilder();

        if (authDetails.getRealmId() != null) {
            authBuilder.setRealmId(authDetails.getRealmId());
        }
        if (authDetails.getRealmName() != null) {
            authBuilder.setRealmName(authDetails.getRealmName());
        }
        if (authDetails.getClientId() != null) {
            authBuilder.setClientId(authDetails.getClientId());
        }
        if (authDetails.getUserId() != null) {
            authBuilder.setUserId(authDetails.getUserId());
        }
        if (authDetails.getIpAddress() != null) {
            authBuilder.setIpAddress(authDetails.getIpAddress());
        }

        return authBuilder.build();
    }
}
