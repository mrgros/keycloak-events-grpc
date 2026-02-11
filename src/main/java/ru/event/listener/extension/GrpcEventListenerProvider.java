package ru.event.listener.extension;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.events.Event;
import org.keycloak.events.EventListenerProvider;
import org.keycloak.events.admin.AdminEvent;
import ru.event.listener.extension.utils.EventUtils;

@Slf4j
@NoArgsConstructor
public class GrpcEventListenerProvider implements EventListenerProvider {
    @Override
    public void onEvent(Event event) {
        log.info("Caught event {}", EventUtils.toString(event));
    }

    @Override
    public void onEvent(AdminEvent adminEvent, boolean b) {
        log.info("Caught admin event {}", EventUtils.toString(adminEvent));
    }

    @Override
    public void close() {

    }
}
