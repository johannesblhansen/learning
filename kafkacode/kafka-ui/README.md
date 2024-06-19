# Kafka cluster with kafka-ui

Following this [guide](https://medium.com/@penkov.vladimir/kafka-cluster-with-ui-and-metrics-easy-setup-d12d1b94eccf)

I managed to get the up and running by following guide.

To start the 2 kafkabrokers and kafka-ui:
```
docker-compose -f kafka-ui-test.yml up
```

To execute kafka-cli commands exec into one of the docker containers found using docker ps.

```
docker exec -it kafka-ui-kafka-0-1 /bin/bash
```

When in the docker container the kafka cli can be used.
```
kafka-topics.sh --bootstrap-server kafka-0:9092 --list
```
Notice the bootstrap server is set to kafka-0:9092 found in the docker compose.


I tried creating a topic using the UI in deployed ui container, which could be found in the list returned by the CLI.