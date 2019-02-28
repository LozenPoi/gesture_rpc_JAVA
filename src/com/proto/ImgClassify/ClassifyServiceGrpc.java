package com.proto.ImgClassify;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.8.0)",
    comments = "Source: ImgClassify.proto")
public final class ClassifyServiceGrpc {

  private ClassifyServiceGrpc() {}

  public static final String SERVICE_NAME = "gesture_rpc.ClassifyService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getClassifyImagesMethod()} instead. 
  public static final io.grpc.MethodDescriptor<com.proto.ImgClassify.ImgClassify.imgs,
      com.proto.ImgClassify.ImgClassify.classified> METHOD_CLASSIFY_IMAGES = getClassifyImagesMethod();

  private static volatile io.grpc.MethodDescriptor<com.proto.ImgClassify.ImgClassify.imgs,
      com.proto.ImgClassify.ImgClassify.classified> getClassifyImagesMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<com.proto.ImgClassify.ImgClassify.imgs,
      com.proto.ImgClassify.ImgClassify.classified> getClassifyImagesMethod() {
    io.grpc.MethodDescriptor<com.proto.ImgClassify.ImgClassify.imgs, com.proto.ImgClassify.ImgClassify.classified> getClassifyImagesMethod;
    if ((getClassifyImagesMethod = ClassifyServiceGrpc.getClassifyImagesMethod) == null) {
      synchronized (ClassifyServiceGrpc.class) {
        if ((getClassifyImagesMethod = ClassifyServiceGrpc.getClassifyImagesMethod) == null) {
          ClassifyServiceGrpc.getClassifyImagesMethod = getClassifyImagesMethod = 
              io.grpc.MethodDescriptor.<com.proto.ImgClassify.ImgClassify.imgs, com.proto.ImgClassify.ImgClassify.classified>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "gesture_rpc.ClassifyService", "ClassifyImages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.ImgClassify.ImgClassify.imgs.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.ImgClassify.ImgClassify.classified.getDefaultInstance()))
                  .setSchemaDescriptor(new ClassifyServiceMethodDescriptorSupplier("ClassifyImages"))
                  .build();
          }
        }
     }
     return getClassifyImagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClassifyServiceStub newStub(io.grpc.Channel channel) {
    return new ClassifyServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClassifyServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ClassifyServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClassifyServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ClassifyServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class ClassifyServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * BiDi Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.ImgClassify.ImgClassify.imgs> classifyImages(
        io.grpc.stub.StreamObserver<com.proto.ImgClassify.ImgClassify.classified> responseObserver) {
      return asyncUnimplementedStreamingCall(getClassifyImagesMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getClassifyImagesMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.proto.ImgClassify.ImgClassify.imgs,
                com.proto.ImgClassify.ImgClassify.classified>(
                  this, METHODID_CLASSIFY_IMAGES)))
          .build();
    }
  }

  /**
   */
  public static final class ClassifyServiceStub extends io.grpc.stub.AbstractStub<ClassifyServiceStub> {
    private ClassifyServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClassifyServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClassifyServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClassifyServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * BiDi Streaming
     * </pre>
     */
    public io.grpc.stub.StreamObserver<com.proto.ImgClassify.ImgClassify.imgs> classifyImages(
        io.grpc.stub.StreamObserver<com.proto.ImgClassify.ImgClassify.classified> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getClassifyImagesMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ClassifyServiceBlockingStub extends io.grpc.stub.AbstractStub<ClassifyServiceBlockingStub> {
    private ClassifyServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClassifyServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClassifyServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClassifyServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ClassifyServiceFutureStub extends io.grpc.stub.AbstractStub<ClassifyServiceFutureStub> {
    private ClassifyServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ClassifyServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClassifyServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ClassifyServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CLASSIFY_IMAGES = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ClassifyServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ClassifyServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CLASSIFY_IMAGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.classifyImages(
              (io.grpc.stub.StreamObserver<com.proto.ImgClassify.ImgClassify.classified>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ClassifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClassifyServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.ImgClassify.ImgClassify.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClassifyService");
    }
  }

  private static final class ClassifyServiceFileDescriptorSupplier
      extends ClassifyServiceBaseDescriptorSupplier {
    ClassifyServiceFileDescriptorSupplier() {}
  }

  private static final class ClassifyServiceMethodDescriptorSupplier
      extends ClassifyServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ClassifyServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ClassifyServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClassifyServiceFileDescriptorSupplier())
              .addMethod(getClassifyImagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
