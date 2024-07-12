
What does performance mean? It is different compared to the context.

For example: 
High Speed Trading System requires latency 
Machine Learning needs lots of data, so performance is throughput.

Examples in the lectures is (There can be many more examples.)
- Latency
	- The time to completion of task. Measured in time units. If the problem space is one big task, then this is approach is the appropriate one.
- Throughput
	- The amount of tasks completed in a given period. Measured in tasks/time unit. If the problem space is many individual task with no dependence on each other, this is the appropriate one. 

Note that the two types of optimization is might have no impact on each other, or even negative impact on each other.



### Latency

How to improve latency by using multi-threaded approach.

Imagine a single task running at in one thread:

![](Pasted%20image%2020240712111850.png)
Solving this task with have latency of time T.

To decrease the time T, we can split the task Task into multiple tasks (if possible) and run them in parallel using multiple threads which will result in faster time T

![](Pasted%20image%2020240712112235.png)

This will theoretically result is N times faster time T to finish the task:

![](Pasted%20image%2020240712112335.png)

In real life, there are 3 considerations we need to answer.
1. What is the best value N, meaning how many subtasks and thereby threads would be used for the best result
2. What is the cost of parallelization of the task ie breaking the task **and** aggregating the results
3. Can any task even be broken into subtasks, and if it can, can all of it be broken into subtasks. 

###### 1: Number of threads to use?
The overall goal should be to use an amount of threads equal to the amount of cores available. This will in theory give true parallelism. Adding more threads is counter productive as they will stand idle and add more unnecessary context switches:


![](Pasted%20image%2020240712113824.png)

So N should be equal to number of cores available. (Runtime.getRuntime().availableProcessers)

This is only true, 
- if the task is non-blocking meaning no I/O calls or sleep etc.
- if nothing else of significance is running on the cpu.

###### 2: Cost parallelization of the task 

![](Pasted%20image%2020240712114826.png)

This that only tasks of a certain size makes sense to break and solve with multiple threads. The bigger the task, the more worth it to pay this overhead.

###### 3: Can a task even be split.
Some tasks can naturally be split it not N equal sizes, but in reality, most tasks can be partially split and sometimes be have to split, aggregated and then split again - calculate something, then use that result to calculate something else.

