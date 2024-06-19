Kafka Docker Setup

https://medium.com/@penkov.vladimir/kafka-cluster-with-ui-and-metrics-easy-setup-d12d1b94eccf

I managed to get the up and running by following guide.
In my project: 

```
docker-compose -f kafka-ui-test.yml up
```

To execute commands I just exec into one of the docker containers found using docker ps.

```
kafka-topics.sh --bootstrap-server kafka-0:9092 --list
```
Notice the bootstrap server is set to kafka-0:9092 found in the docker compose.


I tried creating a topic using the UI in deployed ui container, which could be found in the list returned by the CLI.

