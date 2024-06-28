#docker_kafka_example 

Kafka using docker
https://www.conduktor.io/kafka/how-to-start-kafka-using-docker/

Followed that guide, and pulled a some docker compose files.

To start a single kafka server and a zookeeper
```
docker-compose -f zk-single-kafka-single.yml up -d
```
Remember there is also a down version of the compose.


To execute commands in the container, use docker exec:
```
docker exec -it kafka1 /bin/bash
```


When executing commands on the kafka server, it needs a command for bootstrap server. Here I used the hostname from the docker compose file - host.docker.internal:29092

```
kafka-topics --bootstrap-server host.docker.internal:29092 --list
```
