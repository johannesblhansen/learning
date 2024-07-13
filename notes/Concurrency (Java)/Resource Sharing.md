Motivation for resource sharing between threads is to save resources, or sometimes it is even necessary.
A typical example is a http service that wraps a database. The service takes many concurrent http requests, and creates a thread for each request, and saves the body into a database. The database connection is shared between the threads, as creating a connection for every thread would be too expensive.

![](Pasted%20image%2020240713214956.png)


This ca cause a problem, if a shared resource is called, that contains non-atomic operations. The error can be unpredictable, as it relates to the when a different threads are being scheduled by the scheduler, and that is outside our control (controlled by the OS)

An example of this.

[README](javacode/multithreading/error-handling/README.md)

