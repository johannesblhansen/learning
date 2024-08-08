package dk.johannes.serverstream;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class ServerStreamServiceMain {
    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(6565).addService(new ServerStreamGRPCService()).build();
        server.start();
        server.awaitTermination();
    }
}