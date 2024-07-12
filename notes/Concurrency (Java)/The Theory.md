
#### Processes and threads

A process is a context of needed to run a program on at the OS level. A process contains everything needed for execution, like files, Heap Data, Code (program instructions) and AT LEAST one thread, the main thread.

Threads are streams of instructions to be executed by the CPU. They contain mainly a stack of instructions (a region in memory) and an Instruction Pointer. Threads are on a process level, and shares a lot of resources from the owning process.
The OS scheduler will schedule and switch between threads.

![](Pasted%20image%2020240710085430.png)
###### In Java

Starting a java program also starts the JVM. There is one JVM per process.
NOTE: Running a webserver like Tomcat is one process with many threads. A Tomcat server does support handling multiple web applications, but it is still one process and one shared JVM.

#####  Context switching

When a CPU takes dismounts one process and load another process.
This is the price of concurrency and is expensive. 

Thrashing: when there are (too) many processes than threads, and the CPU spends more time on context switching and executing actual programs. 

Context switching between threads is MUCH cheaper than between processes.

