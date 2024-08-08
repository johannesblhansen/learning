package dk.johannes.clientstream;

import dk.johannes.serverstream.ServerStreamGRPCService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ClientStreamServiceMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(6565).addService(new ClientStreamGRPCService()).build();
        server.start();
        server.awaitTermination();
    }
}
