
So far only messages have been defined using protobuf. The protobuf files also act as contract between server and clients.
Like a openapi spec, it is shared between server and client and used to autogenerate code - protobuf uses the protoc binary provided.

GRPC offers 4 communication patterns (REST only have unary request / response)

![](Pasted%20image%2020240721114150.png)

#### Coding in java

[README for grpc servers](javacode/grpc/grpc-server/README.md)

Note it is possible to use postman for grpc by importing the proto file and using it as contract:

![](Pasted%20image%2020240722090459.png)

##### Building a client

Sending information to the server is initiated by a stub (of the service), going through a channel. This means we have to use channel and a stub

![](Pasted%20image%2020240723203038.png)

