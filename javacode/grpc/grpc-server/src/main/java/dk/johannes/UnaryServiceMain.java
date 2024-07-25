package dk.johannes;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class UnaryServiceMain {
    public static void main(String[] args) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(6565).addService(new UnaryGRPCService()).build();
        server.start();
        server.awaitTermination();
    }
}