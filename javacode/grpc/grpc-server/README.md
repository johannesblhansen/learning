### Project for creating grpc servers

#### Server
This project will focus on building grpc servers. The grpc framework here use dependency grpc-netty-shaded to build an 
underlying netty server:
```
    Server server = ServerBuilder.forPort(6565).addService(new MyGrpcService()).build();
    server.start();
    server.awaitTermination();
```

###### Unary impl

