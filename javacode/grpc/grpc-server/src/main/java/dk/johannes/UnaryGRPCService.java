package dk.johannes;

import dk.johannes.proto.MyRequest;
import dk.johannes.proto.MyResponse;
import dk.johannes.proto.MyServiceNameGrpc;
import io.grpc.stub.StreamObserver;

public class UnaryGRPCService extends MyServiceNameGrpc.MyServiceNameImplBase {

    @Override
    public void getMyResponse(MyRequest request, StreamObserver<MyResponse> responseObserver) { //Notice that the return type is void
        MyResponse myResponse = MyResponse.newBuilder().setMyResponseId(1).setMyResponseMessage("My response message").build();
        responseObserver.onNext(myResponse); //This sends the response
        responseObserver.onCompleted(); //This closes the interaction. Since it is unary, only one response is expected
    }
}
