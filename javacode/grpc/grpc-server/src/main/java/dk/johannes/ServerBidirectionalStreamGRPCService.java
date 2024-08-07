package dk.johannes;

import dk.johannes.proto.stream.MyBidirectionalStreamRequest;
import dk.johannes.proto.stream.MyBidirectionalStreamResponse;
import dk.johannes.proto.stream.MyBidirectionalStreamServiceNameGrpc;
import io.grpc.stub.StreamObserver;

public class ServerBidirectionalStreamGRPCService extends MyBidirectionalStreamServiceNameGrpc.MyBidirectionalStreamServiceNameImplBase {


    @Override
    public StreamObserver<MyBidirectionalStreamRequest> getMyResponse(StreamObserver<MyBidirectionalStreamResponse> responseObserver) {
        return super.getMyResponse(responseObserver);
    }
}
