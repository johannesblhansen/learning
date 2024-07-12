
To coordinate threads and wait until they have finished their executing, Thread class provide the join method.

```
targetThread.join()
```
This will block the current active thread of execution (typically the main thread), until the target thread is done with its execution (whatever is in the run method)

