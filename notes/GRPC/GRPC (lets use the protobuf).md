
So far only messages have been defined using protobuf. The protobuf files also act as contract between server and clients.
Like a openapi spec, it is shared between server and client and used to autogenerate code - protobuf uses the protoc binary provided.

GRPC offers 4 communication patterns (REST only have unary request / response)

![](Pasted%20image%2020240721114150.png)

