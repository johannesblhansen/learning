# Kafka cluster with kafka-ui

Following this [guide](https://medium.com/@penkov.vladimir/kafka-cluster-with-ui-and-metrics-easy-setup-d12d1b94eccf)

I managed to get the up and running by following guide.

To start the 2 kafka brokers and kafka-ui:
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


# Kafka cluster with kafka-ui and external port tested and working

Following this [guide](https://hackernoon.com/setting-up-kafka-on-docker-for-local-development)

I was apple to copy/paste some of that setting to create cluster using zookeeper and 1 kafka broker but adding from the above the [kafka ui](https://github.com/provectus/kafka-ui) cluster monitor.

This exposes the single broker as _bootstrapbroker_ on localhost:9093

To start the cluster

```
docker-compose -f kafka-ui-with-external-working.yml up
```

To use the cli first connect to the container
```
docker exec -it kafka-ui-kafka-0-1 /bin/bash
```

Then kafka cli commands can be used by:
```
kafka-topics.sh --bootstrap-server kafka:9092 --list
```