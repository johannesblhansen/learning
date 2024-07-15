# Kafka related producers and consumers using spring kafka.

[Spring Kafka](https://docs.spring.io/spring-kafka/reference/index.html)

Small hello world type producers and consumers designed to work with the kafkacluster setup in the kafka-ui folder 
under kafka code.

They connect by being on the same docker network (created by kafka-ui compose file) and using the env variable 
```
bootstrap.address
```
The value that is docker picks up inside the network is https://kafkabroker0:9092

The images are very basic, and simply copies the target/jar file and runs it using a CMD. That means that to get 
new code deployed:
 - Build the code using mvn
 - Build new images by added --build to docker compose up.

### To run it:

```
docker compose up --build
```
Note: The build forces a rebuild of images, as caching creating issues.

### To run it directly on the machine (no docker)

The kafka-ui project sets up the cluster with external access as well using https://localhost:9093

To use this run this, there is a localdev profile configured with that address.