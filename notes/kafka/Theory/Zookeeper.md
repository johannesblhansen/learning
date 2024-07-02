#### Zookeeper

Zookeeper is used as a metadata manager for a kafka cluster. It manages the brokers, sends them updates when topics changes, when brokers goes up or down, when partitions are created removed, leaders elections etc.

Zookeeper is on the way out. It used to be, that connecting a client (producer, consumer, ui client etc) to kafka happened through zookeeper, but but since kafka 2.2. Instead use kafka directly by pointing the clients to a bootstrap broker instead.

From 4.0 zookeeper will be completely out, but if only direct connections to bootstrap brokers where made in your code, you will have no problem.

