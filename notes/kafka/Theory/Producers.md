- Producers write data to topics (the partitions within the topics)
- Producers know which partition to write to and where to find it - which broker (It is not kafka that makes this decision.)
- If a kafka broker fails, a producer should be automatically recover.

A producer will spread messages across all partitions. This gives load-balancing and scaling

![](Pasted%20image%2020240621221325.png)


#### Message Keys

A producer can use an optional key with their message.

If the key is not provided / key is null, then producers distributes round robin to the partitions of a topic.

If the key *is* provided, all messages with the same key will go to the same partition (through a hashing strategy).
Keys are for situations where ordering is required.
Even if every message with the same key goes to the same partition, there is still some load balancing:

![](Pasted%20image%2020240624214939.png)

Note it is the producer who chooses the partition through the Producer Partitioner logic
#### Message structure:
What a message looks like created by the producer:

![](Pasted%20image%2020240624215129.png)
#### Serialization
Note kafka messages are bytes only. That means we must serialize and deserialize all messages.
This is done as follows:

![](Pasted%20image%2020240624215436.png)

