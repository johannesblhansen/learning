package dk.johannes;

import dk.johannes.proto.MyRequest;
import dk.johannes.proto.MyResponse;
import dk.johannes.proto.MyServiceNameGrpc;
import io.grpc.stub.StreamObserver;

public class MyGrpcService extends MyServiceNameGrpc.MyServiceNameImplBase {

    @Override
    public void getMyResponse(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        MyResponse myResponse = MyResponse.newBuilder().setMyResponseId(1).setMyResponseMessage("My response message").build();
        responseObserver.onNext(myResponse);
        responseObserver.onCompleted();
    }
}
