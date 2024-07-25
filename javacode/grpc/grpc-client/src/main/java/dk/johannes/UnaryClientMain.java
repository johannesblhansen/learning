package dk.johannes;

import dk.johannes.proto.MyRequest;
import dk.johannes.proto.MyResponse;
import dk.johannes.proto.MyServiceNameGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UnaryClientMain {
    public static void main(String[] args) {

        //Channel i generally created once per application.
        //Note the channel is managed by the framework.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        //Uses the channel
        //This is thread safe
        MyServiceNameGrpc.MyServiceNameBlockingStub myServiceNameBlockingStub = MyServiceNameGrpc.newBlockingStub(channel);
        MyResponse clientMessage = myServiceNameBlockingStub.getMyResponse(MyRequest.newBuilder().setMyRequestId(1).setMyRequestMessage("client message").build());
        System.out.println(clientMessage.getMyResponseMessage());
    }
}