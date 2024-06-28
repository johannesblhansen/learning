#### Kafka Topic replication

To make sure a kafka topic is durable, the partitions that makes up the topic are replicated and spread across brokers. This is done through a partition leader / in sync replica system.

A producer can only send data to the leader, which will in turn handle spreading that data the ISR's

Example:

![[Pasted image 20240628065343.png]]

In this case any 1 of the brokers can die, and both partitions of topic-a will still be available. If a broker with a leader dies, and new leader is automatically found.

If the cluster can handle 1 broker dying, it has a replication factor of 2. Adding more partitions across more brokers can increase this replication factor