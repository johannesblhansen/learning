package dk.johannes;

import dk.johannes.proto.stream.MyStreamRequest;
import dk.johannes.proto.stream.MyStreamResponse;
import dk.johannes.proto.stream.MyStreamServiceNameGrpc;
import io.grpc.stub.StreamObserver;

/**
 * Server used for the server streaming scenario
 */
public class ServerStreamGRPCService extends MyStreamServiceNameGrpc.MyStreamServiceNameImplBase {

    @Override
    public void getMyResponse(MyStreamRequest request, StreamObserver<MyStreamResponse> responseObserver) {
        System.out.println("starting on resps");
        MyStreamResponse myStreamResponse = MyStreamResponse.newBuilder().setMyResponseId(1).setMyResponseMessage("My response message " + 1).build();
        responseObserver.onNext(myStreamResponse);

        MyStreamResponse myStreamResponse2 = MyStreamResponse.newBuilder().setMyResponseId(2).setMyResponseMessage("My response message " + 2).build();

        responseObserver.onNext(myStreamResponse2);

        System.out.println("Calling onCompleted");
        responseObserver.onCompleted(); //This closes the interaction. Since it is unary, only one response is expected
    }
}
