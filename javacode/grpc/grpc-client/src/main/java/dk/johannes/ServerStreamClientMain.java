package dk.johannes;

import dk.johannes.proto.stream.MyStreamRequest;
import dk.johannes.proto.stream.MyStreamResponse;
import dk.johannes.proto.stream.MyStreamServiceNameGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.Duration;

/**
 * Async client used for server streaming
 */
public class ServerStreamClientMain {
    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        MyStreamServiceNameGrpc.MyStreamServiceNameStub myStreamServiceNameStub = MyStreamServiceNameGrpc.newStub(channel);
        myStreamServiceNameStub.getMyResponse(MyStreamRequest.newBuilder().setMyRequestId(1).setMyRequestMessage("client message").build(), new StreamObserver<>() {
            @Override
            public void onNext(MyStreamResponse myResponse) {
                System.out.println("I got a response from the server");
                System.out.println(myResponse);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("got error");
            }

            @Override
            public void onCompleted() {
                System.out.println("got completed");
            }
        });
        System.out.println("Starting to sleep");
        Thread.sleep(Duration.ofSeconds(30));

    }
}