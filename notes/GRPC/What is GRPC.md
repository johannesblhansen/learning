GRPC is a framework for building service to service api's.

It uses protobufs for data transfer and http 2 protocol.

##### Motivation:
Api's build with grpc are much faster and more efficient than json, as the data transferred is not in text format (like REST is typically json), protobuf but binary. That means smaller packages and less cpu on serialization and deserialization.
It supports has streaming on top of normal unary request / response type communication.

##### How it works

![](Pasted%20image%2020240720120013.png)

- First proto files are defined, which creates the contract of the api. 
- These files are processed by the protobuf compiler protoc making the stubs for the clients and the base classes for the server
- Clients and servers use the code generated to communicate.

![](Pasted%20image%2020240720120650.png)

