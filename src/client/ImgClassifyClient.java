package client;

import com.proto.ImgClassify.*;
import io.grpc.netty.shaded.io.grpc.netty.GrpcSslContexts;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.net.ssl.SSLException;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

//public class ImgClassifyClient {
//
//    public static void main(String[] args) throws InterruptedException {
//
//        //ImgClassifyClient main = new ImgClassifyClient();
//
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 2007).build();
//        ClassifyServiceGrpc.ClassifyServiceStub service = ClassifyServiceGrpc.newStub(channel);
//
//        StreamObserver<ImgClassify.imgs> observer = service.classifyImages(new StreamObserver<ImgClassify.classified>() {
//            @Override
//            public void onNext(ImgClassify.classified value) {
//                System.out.println("Response from server: " + value.getNumImg());
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println("on error");
//                t.printStackTrace();
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("on completed");
//            }
//        });
//        //requestObserverRef.set(observer);
//        ImgClassify.imgs example = ImgClassify.imgs.newBuilder()
//                .setNumImg(3)
//                .build();
//        observer.onNext(example);
//        //finishedLatch.await();
//        observer.onCompleted();
//
////        try {
////            latch.await(3, TimeUnit.SECONDS);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//    }
//}

public class ImgClassifyClient{

    private static final Logger logger = Logger.getLogger(ImgClassifyClient.class.getName());

    private final ManagedChannel channel;
    private final ClassifyServiceGrpc.ClassifyServiceStub asyncStub;

    public ImgClassifyClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();
        this.asyncStub = ClassifyServiceGrpc.newStub(this.channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    private ImgClassify.imgs newImg(int num_img) {
        return ImgClassify.imgs.newBuilder().setNumImg(num_img)
                .build();
    }

    public CountDownLatch imgClassify() {

        final CountDownLatch finishLatch = new CountDownLatch(1);
        StreamObserver<ImgClassify.imgs> requestObserver =
                asyncStub.classifyImages(new StreamObserver<ImgClassify.classified>() {
                    @Override
                    public void onNext(ImgClassify.classified result) {
//                        if (testHelper != null) {
//                            testHelper.onMessage(note);
//                        }
                        logger.info(Integer.toString(result.getNumImg()));
                    }

                    @Override
                    public void onError(Throwable t) {
                        logger.warning("RouteChat Failed");
                        t.printStackTrace();
//                        if (testHelper != null) {
//                            testHelper.onRpcError(t);
//                        }
                        finishLatch.countDown();
                    }

                    @Override
                    public void onCompleted() {
                        logger.info("Finished RouteChat");
                        finishLatch.countDown();
                    }
                });

        try {
            ImgClassify.imgs[] requests =
                    {newImg(1), newImg(2),
                            newImg(3), newImg(4)};

            for (ImgClassify.imgs request : requests) {
                requestObserver.onNext(request);
            }
        } catch (RuntimeException e) {
            // Cancel RPC
            requestObserver.onError(e);
            throw e;
        }
        // Mark the end of requests.
        requestObserver.onCompleted();

        // Return the latch while receiving happens asynchronously.
        return finishLatch;
    }

    public static void main(String[] args) throws InterruptedException {

        ImgClassifyClient client = new ImgClassifyClient("localhost", 8080);
        try {
            // Send and receive some notes.
            CountDownLatch finishLatch = client.imgClassify();

            if (!finishLatch.await(1, TimeUnit.MINUTES)) {
                logger.warning("routeChat cannot finish within 1 minutes");
            }
        } finally {
            client.shutdown();
        }
    }

}
