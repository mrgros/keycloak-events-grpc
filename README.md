# keycloak-events-grpc

Небольшой адаптер для Keycloak, который пересылает события (адmin- и обычные события) по gRPC.

**Maven coordinates**: `ru.keycloak.grpc:keycloak-events-grpc:1.0-SNAPSHOT` (см. [pom.xml](pom.xml)).

**Кратко**
- Плагин регистрируется в Keycloak как `EventListenerProvider` и отправляет события на внешний gRPC-сервер.
- Сервис gRPC определён в `src/proto/keycloak/event/v1/event_api.proto` (методы `Create` и `CreateAdmin`).
- Сгенерированные Java классы находятся в `src/main/java/com/keycloak/event/v1`.

**Полезные файлы**
- `pom.xml` — сборка и зависимости.  
- `src/proto/keycloak/event/v1/event_api.proto` — gRPC API (EventAPI).  
- `src/proto/keycloak/event/v1/event.proto` — описания сообщений (Event, AdminEvent, enum'ы).  
- `src/main/java/com/keycloak/event/v1` — сгенерированные классы по proto.  
- `src/main/java/ru/event/listener/extension/GrpcEventListenerProviderFactory.java` — фабрика провайдера для Keycloak.  
- `src/main/java/ru/event/listener/extension/GrpcEventListenerProvider.java` — реализация логики отправки событий.  
- `src/main/resources/META-INF/services/org.keycloak.events.EventListenerProviderFactory` — регистрация провайдера.  
- `buf.yaml`, `buf.gen.yaml` — конфигурация для генерации proto.  
- `docker-compose.yml` — пример окружения с Keycloak и PostgreSQL (в README перечислены только переменные `GRPC_HOST`/`GRPC_PORT`, остальные переменные из `docker-compose.yml` опущены).

Быстрый старт
-----------

1) Генерация Java-классов из proto

	Если у вас установлен `buf`:

	```bash
	buf generate --template buf.gen.yaml
	```

	Альтернативно можно использовать контейнер с `buf` (если предпочитаете Docker).

2) Сборка

	```bash
	mvn -DskipTests clean package
	```

	Итоговый артефакт: `target/grpc-event-listener.jar` (в `pom.xml` finalName: `grpc-event-listener`).

3) Деплой в Keycloak

	- Скопируйте `target/grpc-event-listener.jar` в директорию `/opt/keycloak/providers/` и перезапустите Keycloak.
	- Либо используйте `docker-compose.yml` и запустите:

	```bash
	docker-compose up --build
	```

Конфигурация провайдера
-----------------------

Провайдер читает только две переменных окружения для gRPC-соединения:

- `GRPC_HOST` — адрес gRPC-сервера (по умолчанию `localhost`).
- `GRPC_PORT` — порт gRPC-сервера (по умолчанию `9090`).

Эти переменные применяются фабрикой `GrpcEventListenerProviderFactory` при инициализации.

gRPC API
-----------------

Сервис `EventAPI` объявлен в `src/proto/keycloak/event/v1/event_api.proto` и содержит два RPC:

- `Create(CreateRequest) returns (CreateResponse)` — для обычных событий (аутентификация, сессии и т.п.).
- `CreateAdmin(CreateAdminRequest) returns (CreateAdminResponse)` — для административных событий.

Ключевые сообщения — `Event`, `AdminEvent`, а также перечисления `EventType` и `OperationType` (см. `event.proto`).

Пример формирования запроса на Java (сокращённо)

```java
CreateRequest req = CreateRequest.newBuilder()
	 .setId(event.getId())
	 .setTime(Timestamp.newBuilder().setSeconds(event.getTime()/1000).setNanos((int)((event.getTime()%1000)*1_000_000)).build())
	 .setType(convertEventType(event.getType()))
	 .setRealmId(event.getRealmId())
	 .setRealmName(event.getRealmName())
	 .setClientId(event.getClientId())
	 .setUserId(event.getUserId())
	 .setSessionId(event.getSessionId())
	 .setIpAddress(event.getIpAddress())
	 .build();

eventApiStub.create(req);
```

В проекте аналогичная логика реализована в `GrpcEventListenerProvider`.

**Примечание**: Для приема сообщений необходимо запустить gRPC-сервер, реализующий сервис `EventAPI`. Пример реализации см. в репозитории [keycloak-events-adapter](https://github.com/mrgros/keycloak-events-adapter).

Проверка и верификация
------------------------

- После старта Keycloak проверьте логи — фабрика логирует инициализацию с хостом/портом: `gRPC listener initialized with host: ..., port: ...`.
- Для локального теста можно поднять тестовый gRPC-сервер на `GRPC_HOST:GRPC_PORT` и убедиться, что сервер получает `Create` и `CreateAdmin` вызовы.

Устранение неполадок
--------------------

- Если классы из `com.keycloak.event.v1` отсутствуют — выполните генерацию через `buf generate`.
- Если Keycloak не отправляет события — проверьте, что провайдер зарегистрирован (файл `META-INF/services/...`) и что провайдер активирован в настройках Keycloak.
- При ошибках соединения — проверьте `GRPC_HOST`/`GRPC_PORT` и сетевые правила/файервол.

Вклад в проект
--------------

Pull requests приветствуются. Обычный workflow: fork → branch → PR. Для изменений в proto сначала обновите `src/proto/...` и `buf.gen.yaml`, затем сгенерируйте Java-классы.

Лицензия
-------

Смотрите файл `LICENSE` в корне репозитория.
