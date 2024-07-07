Consumer read data from a topic by topic name. It is a ***pull*** model.

Consumers automatically know what broker to read from and how to recover if a partition goes down. The consumer handles the connectivity.

A consumer reads in order, but only within the partition. There is no guarantee of ordering between partitions:

![](Pasted%20image%2020240624221945.png)

Consumer also use serialization in the form of deserializers.

### Consumer Groups

Consumer within the same application (for scaling) can be set up in a consumer group. This is a grouping of consumers that divides an topics partition.
Each consumer within the group reads from exclusive partitions:

![](Pasted%20image%2020240624222540.png)

If additional consumers are added, so there amore consumer than partitions of the topic, the consumers become inactive (in standby):

![](Pasted%20image%2020240624222701.png)


More consumer groups can read from the topic. The partitions are only exclusive within the consumer group:
![](Pasted%20image%2020240624222839.png)


This is very normal setup. Consider the example of a stream of gps locations of trucks. Then consumers might both a tracking service and a guiding service and whatever service.

#### Consumer offsets

Kafka stores the offsets of where a consumer group has reached on each partition.
These consumer offsets are committed by the consumers to kafka that stores them on the topic the __consumer_offsets

That way kafka knows the consumer was if it dies.

There are 3 different ways of handling delivery and commit offsets. 

![](Pasted%20image%2020240624224237.png)

