## Topic and Partitions

#### Topic:
A particular stream of any kind of data
There is no data verification on topic

A topic is identified by name.
Supports any kind of message format / data - avro, json, binary etc etc

The messages in sequence within a topic is called a data stream.

Topics *cannot* be queried. A producer in and consumer out. 

Topics lives in Kafka Clusters.

![](Pasted%20image%2020240621214342.png)


#### Partitions
Topics are split into any number of partitions. A message for a topic goes into a partitions.

##### Offsets
- Messages in each partition is ordered and isolated from other partitions. The message within a partition gets an id, called the partition offset. 
- The offset is specific to a partition. Offset 2 in partition 0 is not necessarily the same as offset 2 in partition 1.
- Offsets are not re-used - even after messages are deleted.

![](Pasted%20image%2020240621214558.png)
The data is immutable. Once it is there, it cannot be changed.
Even if the data immutable, it only leaves for a limited time (default one week)

Within each partition ordering is guaranteed, but not across partitions.

