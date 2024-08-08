package dk.johannes.clientstream;

import dk.johannes.proto.MyClientRequest;
import dk.johannes.proto.MyClientResponse;
import dk.johannes.proto.MyClientServiceNameGrpc;
import io.grpc.stub.StreamObserver;

public class ClientStreamGRPCService extends MyClientServiceNameGrpc.MyClientServiceNameImplBase {

    @Override
    public StreamObserver<MyClientRequest> getMyResponse(StreamObserver<MyClientResponse> responseObserver) {

        /*
        The implementation of StreamObserver<MyClientRequest> that is returned by the method, is used to handle inbound
        message from the client.
        To give a response to such a message, the RequestHandler (which is an StreamObserver<MyClientRequest> impl) gets
        the server response stream observer to act on it.
         */

        return new RequestHandler(responseObserver);
    }
}
