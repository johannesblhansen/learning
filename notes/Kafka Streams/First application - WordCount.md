
The WordCount application, counts occurrence of words (split by space) processed by a stream.  One message might contain many words:
```
<null, "Kafka Kafka Streams etc">
```

NOTE: Making an application, it has to have an application id. That application id does many things, but most importantly, it will be the consumer group id in kafka

```
group.id = application.id
```


It can be helpful to analyse what actions needs to be taken, and how to take them.

In case of the of the WordCount app:

![](Pasted%20image%2020241006084739.png)

Internal topics.
Kafka Streams will create internal topic. Do not touch them, they are internally managed.

![](Pasted%20image%2020241006100908.png)

Running the word count locally we get (kafka ui installed on the cluster):

![](Pasted%20image%2020241006101005.png)

