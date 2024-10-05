
# Kafka cluster with kafka-ui and external port tested and working
*NOTE: This is the main cluster used for other programming examples in the learning project*

Following this [guide](https://hackernoon.com/setting-up-kafka-on-docker-for-local-development)

I was apple to copy/paste some of that setting to create cluster using zookeeper and 1 kafka broker but adding from the above the [kafka ui](https://github.com/provectus/kafka-ui) cluster monitor.

This exposes the single broker as _bootstrapbroker_ on localhost:9093

The exposes kafka-ui on localhost:8080

To start the cluster

NOTE: If on windows docker compose might be docker-compose

```
docker compose -f kafka-ui-with-external-working.yml up
```

NOTE: Check for residual volumes from earlier starts. If any volumes related to kafka ui or kafka zookeeper is present, they need to be removed.
```
docker volume ls
```

To use the cli first connect to the container
```
docker exec -it kafkabroker0 /bin/bash
```

Then kafka cli commands can be used by:
```
kafka-topics.sh --bootstrap-server kafkabroker0:9092 --list
```

Another useful cli command is creating simple consumer from inside the container
```
kafka-console-consumer.sh --bootstrap-server kafkabroker0:9092 --topic johannestopic --from-beginning
```
Or just creating it from the local machine
```
kafka-console-consumer.sh --bootstrap-server localhost:9093 --topic johannestopic --from-beginning
```

# Kafka cluster with kafka-ui NO ZOOKEEPER

Following this [guide](https://medium.com/@penkov.vladimir/kafka-cluster-with-ui-and-metrics-easy-setup-d12d1b94eccf)

I managed to get the up and running by following guide.

To start the 2 kafka brokers and kafka-ui:
```
docker compose -f kafka-ui-test.yml up
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