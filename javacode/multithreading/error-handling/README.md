### Module for testing multithreaded problems which comes from resource sharing.

#### ForcingIncrementError

Here the Incrementer class is a shared resource given to two threads. Those threads call the non-atomic counter++ and
counter--.

The expected result would be 0, since one thread increments 100000 times and the other decreases 100000 times. However, 
that is not the case, and the result even differs from run to run.

![](Pasted%20image%2020240713222310.png)

Note counter++ is really 3 operations, even though it looks like one in the javacode.
The above sequence shows how all of the decrement is lost, as it is overwritten by the increment.
