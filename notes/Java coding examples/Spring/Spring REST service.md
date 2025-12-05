#Spring #code_example
#### General Notes
I have created simple spring boot applications, where one produces messages, and the other simply calls the producer via rest templete.
To trigger to consumer, it exposes its own rest endpoint.
The purpose is to have a generalized setup, that can be used for different scenarios.

[Root folder](../../javacode/rest)

##### Docker and Docker Compose
#docker_component 

The two applications are dockerized and can be started together using docker compose
They will use internal network for the consumer to talk to producer.

##### Threads and Embedded Tomcat behavior

Look in the consumer readme
[Readme](javacode/rest/basic-rest-app/README.md)