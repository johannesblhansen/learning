### Throughput

The number of task completed in a given period (10 tasks per second for example) so TASK / TIME
When the goal is to complete as many tasks as possible in a given time, and the tasks are *independent* from each other.  

In this scenario, we do not try to break a task into subtasks, which comes at a cost seen in [Performance Optimization - Latency](Performance%20Optimization%20-%20Latency.md), we simply try to assign a full task to each thread. This is possible if the tasks are independent from each other.

There is still some costs:
![](Pasted%20image%2020240713143852.png)

To further reduce cost a technique to use is Thread pooling.

###### Thread Pooling

A thread pool works by reusing threads, and thereby saving cost of creating and shutting down threads. It consist of a pool of threads and a task queue.
Each task is assigned to a thread and completed by that thread, which is then available for the next task. If all threads are busy, then the task is put into a queue belonging to the thread pool.

![](Pasted%20image%2020240713144401.png)

Creating a thread pool implementation is hard, but JDK comes with a bunch of them to use.

A common example of optimizing for throughput is an http server (like tomcat / netty). I have played around with here: [README](javacode/rest/basic-rest-app/README.md#Use Case: Overloading a Tomcat embedded server)

To maximize performance for non-blocking tasks, the number of threads in the thread pool should be equal to the number of core available. That way the each core will (in theory) be working on task and do no context switching until that task is complete.

![](Pasted%20image%2020240713152401.png)

However, if the tasks include blocking operations like I/O calls, more does make sense to add more cores.