#### Brokers

Brokers could also be called kafka servers. A broker is identified with and integer id

A kakfa cluster often consist of multiple brokers.

Connecting to one broker in a cluster (a bootstrap broker) all the remaining brokers can be found from that broker.

A topic is usually spread across multiple brokers, but is done so by spreading partitions of the topic spread across to brokers.
This is what enables horizontal scaling - a topic is worked with a single entity, but there can be any number of partitions underneath on any number of brokers

Example:

![[Pasted image 20240628063006.png]]
Here we have 2 topics using 3 brokers. 

#### Broker discovery

Each broker can be a bootstrap broker, meaning that it can provide necessary bootstrapping metadata for a client to find all other brokers in the cluster, the topics and partitions etc.

![[Pasted image 20240628063444.png]]
