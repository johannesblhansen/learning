package dk.johannes.clientstream;

import dk.johannes.proto.MyClientRequest;
import dk.johannes.proto.MyClientResponse;
import io.grpc.stub.StreamObserver;

public class RequestHandler implements StreamObserver<MyClientRequest> {

    private final StreamObserver<MyClientResponse> responseStreamObserver;

    private int requestCount = 0;

    //Get the response stream observer, to act on it, according to client input from the client stream observer
    public RequestHandler(StreamObserver<MyClientResponse> responseStreamObserver) {
        this.responseStreamObserver = responseStreamObserver;
    }

    @Override
    public void onNext(MyClientRequest myClientRequest) {
        if (requestCount > 2) {
            System.out.println("I got as many requests as I want. Shutting down...");
            this.onCompleted();
        }
        System.out.println("I got something from the client");
        requestCount++;
    }

    @Override
    public void onError(Throwable throwable) {
        //Not impl in this example
    }

    @Override
    public void onCompleted() {
        System.out.println("RequestHandler shutting down");
        //Send a message to the client
        responseStreamObserver.onNext(MyClientResponse.newBuilder().setMyResponseId(1).setMyResponseMessage("I got something from you").build());
        //Shut down the connection
        responseStreamObserver.onCompleted();

    }
}
