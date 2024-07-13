
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

##### Memory regions (Stack vs Heap)

There are two types of memory allocation in java, the heap and the stack.

###### Stack:
The stack is region in memory isolated to a single thread: 
![](Pasted%20image%2020240713203804.png)

The stack contains:
- Method calls
- Arguments 
- Local variables

Each method call builds a FRAME on the stack, with the arguments and local variables. The frames are removed as the methods are resolved.

![](Pasted%20image%2020240713204129.png)

Everything on the stack is completely isolated to the thread the stack is attached to. 

A thread contains a stack and an instruction pointer, that together with the stack it points to, can be considered the state of the threads execution.

Note: In intellij debugging, the stacks of a thread is display as well as their variables:

![](Pasted%20image%2020240713204726.png)
##### Heap:

The heap is shared memory at a process level, meaning that it is shared across all threads.

What goes on the heap?
- Objects
	- Strings
	- Collections
	- Etc
- Members of classes (non-static fields for example)
- Static variables
The heap is governed by the **Garbage Collector**

Summary
![](Pasted%20image%2020240713205608.png)