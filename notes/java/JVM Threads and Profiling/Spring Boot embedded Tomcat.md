
#### An experiment on http request handling

Understanding the how http requests are handled by tomcat embedded by Spring Boot

An embedded Tomcat server has a number of worker threads handling incoming http requests. One request is assigned one thread.

If all threads are in use, the request goes on a queue. If the queue is full, the server throws an error

```
java.util.concurrent.RejectedExecutionException: Queue capacity is full
```

There are properties to be control this behavior, if the default is not used:
```
server.tomcat.threads.min-spare=2  
server.tomcat.threads.max=50  
server.tomcat.threads.max-queue-capacity=5
```

They where found from the common application properties appendix:
https://docs.spring.io/spring-boot/appendix/application-properties/index.html

To see the threads used, I used VisualVM.

##### Code
On the consumer (which uses spring async), look for the Task threads. The default number of task threads has to be increased. See [Readme](../../../javacode/rest/basic-rest-app/README.md)

On the producer the queue size of the embedded tomcat is reduced from the standard 200 to 20 to provoke the error.