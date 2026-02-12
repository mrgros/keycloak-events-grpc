package ru.event.listener.extension.keycloak.event.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * EventAPI service provides methods for creating and managing Keycloak events
 * through gRPC interface. It supports both admin events (administrative operations)
 * and regular events (authentication/authorization).
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class EventAPIGrpc {

  private EventAPIGrpc() {}

  public static final java.lang.String SERVICE_NAME = "keycloak.event.v1.EventAPI";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest,
      ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse> getCreateAdminMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateAdmin",
      requestType = ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest.class,
      responseType = ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest,
      ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse> getCreateAdminMethod() {
    io.grpc.MethodDescriptor<ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest, ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse> getCreateAdminMethod;
    if ((getCreateAdminMethod = EventAPIGrpc.getCreateAdminMethod) == null) {
      synchronized (EventAPIGrpc.class) {
        if ((getCreateAdminMethod = EventAPIGrpc.getCreateAdminMethod) == null) {
          EventAPIGrpc.getCreateAdminMethod = getCreateAdminMethod =
              io.grpc.MethodDescriptor.<ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest, ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateAdmin"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventAPIMethodDescriptorSupplier("CreateAdmin"))
              .build();
        }
      }
    }
    return getCreateAdminMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ru.event.listener.extension.keycloak.event.v1.CreateRequest,
      ru.event.listener.extension.keycloak.event.v1.CreateResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = ru.event.listener.extension.keycloak.event.v1.CreateRequest.class,
      responseType = ru.event.listener.extension.keycloak.event.v1.CreateResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ru.event.listener.extension.keycloak.event.v1.CreateRequest,
      ru.event.listener.extension.keycloak.event.v1.CreateResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<ru.event.listener.extension.keycloak.event.v1.CreateRequest, ru.event.listener.extension.keycloak.event.v1.CreateResponse> getCreateMethod;
    if ((getCreateMethod = EventAPIGrpc.getCreateMethod) == null) {
      synchronized (EventAPIGrpc.class) {
        if ((getCreateMethod = EventAPIGrpc.getCreateMethod) == null) {
          EventAPIGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<ru.event.listener.extension.keycloak.event.v1.CreateRequest, ru.event.listener.extension.keycloak.event.v1.CreateResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.event.listener.extension.keycloak.event.v1.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ru.event.listener.extension.keycloak.event.v1.CreateResponse.getDefaultInstance()))
              .setSchemaDescriptor(new EventAPIMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static EventAPIStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventAPIStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventAPIStub>() {
        @java.lang.Override
        public EventAPIStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventAPIStub(channel, callOptions);
        }
      };
    return EventAPIStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static EventAPIBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventAPIBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventAPIBlockingV2Stub>() {
        @java.lang.Override
        public EventAPIBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventAPIBlockingV2Stub(channel, callOptions);
        }
      };
    return EventAPIBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EventAPIBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventAPIBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventAPIBlockingStub>() {
        @java.lang.Override
        public EventAPIBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventAPIBlockingStub(channel, callOptions);
        }
      };
    return EventAPIBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static EventAPIFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EventAPIFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<EventAPIFutureStub>() {
        @java.lang.Override
        public EventAPIFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new EventAPIFutureStub(channel, callOptions);
        }
      };
    return EventAPIFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * EventAPI service provides methods for creating and managing Keycloak events
   * through gRPC interface. It supports both admin events (administrative operations)
   * and regular events (authentication/authorization).
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * CreateAdmin creates an admin event for administrative operations in Keycloak
     * such as user management, realm configuration, and other administrative tasks.
     * </pre>
     */
    default void createAdmin(ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest request,
        io.grpc.stub.StreamObserver<ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateAdminMethod(), responseObserver);
    }

    /**
     * <pre>
     * Create creates a regular event for authentication and authorization operations
     * in Keycloak such as user login, logout, token exchange, and other security events.
     * </pre>
     */
    default void create(ru.event.listener.extension.keycloak.event.v1.CreateRequest request,
        io.grpc.stub.StreamObserver<ru.event.listener.extension.keycloak.event.v1.CreateResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service EventAPI.
   * <pre>
   * EventAPI service provides methods for creating and managing Keycloak events
   * through gRPC interface. It supports both admin events (administrative operations)
   * and regular events (authentication/authorization).
   * </pre>
   */
  public static abstract class EventAPIImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return EventAPIGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service EventAPI.
   * <pre>
   * EventAPI service provides methods for creating and managing Keycloak events
   * through gRPC interface. It supports both admin events (administrative operations)
   * and regular events (authentication/authorization).
   * </pre>
   */
  public static final class EventAPIStub
      extends io.grpc.stub.AbstractAsyncStub<EventAPIStub> {
    private EventAPIStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventAPIStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventAPIStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateAdmin creates an admin event for administrative operations in Keycloak
     * such as user management, realm configuration, and other administrative tasks.
     * </pre>
     */
    public void createAdmin(ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest request,
        io.grpc.stub.StreamObserver<ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateAdminMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Create creates a regular event for authentication and authorization operations
     * in Keycloak such as user login, logout, token exchange, and other security events.
     * </pre>
     */
    public void create(ru.event.listener.extension.keycloak.event.v1.CreateRequest request,
        io.grpc.stub.StreamObserver<ru.event.listener.extension.keycloak.event.v1.CreateResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service EventAPI.
   * <pre>
   * EventAPI service provides methods for creating and managing Keycloak events
   * through gRPC interface. It supports both admin events (administrative operations)
   * and regular events (authentication/authorization).
   * </pre>
   */
  public static final class EventAPIBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<EventAPIBlockingV2Stub> {
    private EventAPIBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventAPIBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventAPIBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateAdmin creates an admin event for administrative operations in Keycloak
     * such as user management, realm configuration, and other administrative tasks.
     * </pre>
     */
    public ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse createAdmin(ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateAdminMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create creates a regular event for authentication and authorization operations
     * in Keycloak such as user login, logout, token exchange, and other security events.
     * </pre>
     */
    public ru.event.listener.extension.keycloak.event.v1.CreateResponse create(ru.event.listener.extension.keycloak.event.v1.CreateRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service EventAPI.
   * <pre>
   * EventAPI service provides methods for creating and managing Keycloak events
   * through gRPC interface. It supports both admin events (administrative operations)
   * and regular events (authentication/authorization).
   * </pre>
   */
  public static final class EventAPIBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EventAPIBlockingStub> {
    private EventAPIBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventAPIBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventAPIBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateAdmin creates an admin event for administrative operations in Keycloak
     * such as user management, realm configuration, and other administrative tasks.
     * </pre>
     */
    public ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse createAdmin(ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateAdminMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Create creates a regular event for authentication and authorization operations
     * in Keycloak such as user login, logout, token exchange, and other security events.
     * </pre>
     */
    public ru.event.listener.extension.keycloak.event.v1.CreateResponse create(ru.event.listener.extension.keycloak.event.v1.CreateRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service EventAPI.
   * <pre>
   * EventAPI service provides methods for creating and managing Keycloak events
   * through gRPC interface. It supports both admin events (administrative operations)
   * and regular events (authentication/authorization).
   * </pre>
   */
  public static final class EventAPIFutureStub
      extends io.grpc.stub.AbstractFutureStub<EventAPIFutureStub> {
    private EventAPIFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EventAPIFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EventAPIFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * CreateAdmin creates an admin event for administrative operations in Keycloak
     * such as user management, realm configuration, and other administrative tasks.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse> createAdmin(
        ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateAdminMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Create creates a regular event for authentication and authorization operations
     * in Keycloak such as user login, logout, token exchange, and other security events.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<ru.event.listener.extension.keycloak.event.v1.CreateResponse> create(
        ru.event.listener.extension.keycloak.event.v1.CreateRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ADMIN = 0;
  private static final int METHODID_CREATE = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ADMIN:
          serviceImpl.createAdmin((ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest) request,
              (io.grpc.stub.StreamObserver<ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse>) responseObserver);
          break;
        case METHODID_CREATE:
          serviceImpl.create((ru.event.listener.extension.keycloak.event.v1.CreateRequest) request,
              (io.grpc.stub.StreamObserver<ru.event.listener.extension.keycloak.event.v1.CreateResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getCreateAdminMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ru.event.listener.extension.keycloak.event.v1.CreateAdminRequest,
              ru.event.listener.extension.keycloak.event.v1.CreateAdminResponse>(
                service, METHODID_CREATE_ADMIN)))
        .addMethod(
          getCreateMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              ru.event.listener.extension.keycloak.event.v1.CreateRequest,
              ru.event.listener.extension.keycloak.event.v1.CreateResponse>(
                service, METHODID_CREATE)))
        .build();
  }

  private static abstract class EventAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EventAPIBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return ru.event.listener.extension.keycloak.event.v1.EventApiProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EventAPI");
    }
  }

  private static final class EventAPIFileDescriptorSupplier
      extends EventAPIBaseDescriptorSupplier {
    EventAPIFileDescriptorSupplier() {}
  }

  private static final class EventAPIMethodDescriptorSupplier
      extends EventAPIBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    EventAPIMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (EventAPIGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new EventAPIFileDescriptorSupplier())
              .addMethod(getCreateAdminMethod())
              .addMethod(getCreateMethod())
              .build();
        }
      }
    }
    return result;
  }
}
