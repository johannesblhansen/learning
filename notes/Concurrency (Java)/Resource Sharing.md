Motivation for resource sharing between threads is to save resources, or sometimes it is even necessary.
A typical example is a http service that wraps a database. The service takes many concurrent http requests, and creates a thread for each request, and saves the body into a database. The database connection is shared between the threads, as creating a connection for every thread would be too expensive.

![](Pasted%20image%2020240713214956.png)


This ca cause a problem, if a shared resource is called, that contains non-atomic operations. The error can be unpredictable, as it relates to the when a different threads are being scheduled by the scheduler, and that is outside our control (controlled by the OS)

An example of this.

[README](javacode/multithreading/error-handling/README.md)

#### Critical Section

When a section of the code is identified as critical, we want to make sure, that when a thread starts executing that section, other threads cannot access the critical section until the initial threads exits.

One solution is the java keyword *synchronized*. 
##### Synchronized.

There are 2 possible approaches:
- Object synchronization (a monitor)
- Block synchronization which is more granular.

The object synchronization is done by adding synchronized to the methods that include critical sections.
Note: In java this is a monitor, meaning it locks all methods using the synchronized keyword in an object, when a thread enters one of those methods.

The Block synchronization uses any object, that is then used for the lock of a section of code:

```
final Object lock1 = new Object();  
public void increment() {  
    synchronized (lock1) {  
        counter++; //non-atomic operation. This is not safe  
    }  
}
```

Note: The synchronization in Java is reentrant. A thread can go from one synchronized method another synchronized method:

![](Pasted%20image%2020240713230650.png)