[The Code](../../javacode/multithreading/thread-creation/README.md)

Notes

Thread.sleep: Tells the OS scheduler not to schedule this thread until the given time has passed. The thread consumes no cpu in this timespan.

Notice the sequence:

```
public static void main(String[] args) {  
    System.out.println("Hello From Thread " + Thread.currentThread().getName());  
    Thread thread = new Thread(() -> System.out.println("Hello From Thread " + Thread.currentThread().getName()));  
    thread.setName("MyThreadName");  
    thread.start();  
    System.out.println("Hello From Thread " + Thread.currentThread().getName());  
}
```
Gives: 
```
Hello From Thread main
Hello From Thread main
Hello From Thread MyThreadName
```
So even though the code starts the new thread before it prints the second hello from the main thread *after* the thread is started, the runtime sequence is different. Since the scheduler needs to mount and start that thread, the main threads actually gets to it second logging point faster.

Using inheritance to create a thread, but extending the thread class:

```
public class ThreadCreationInheritanceMain {  
  
    public static void main(String[] args){  
        MyThread myThread = new MyThread();  
        myThread.start();  
    }  
  
    private static class MyThread extends Thread {  
        @Override  
        public void run(){  
            System.out.println("Hello from thread");  
        }  
    }  
}
```
This can have some upside to it. All the internals like id and name of the Thread class is available. 
###### Exception handling.

Any unhandled exception that happens in thread kills the thread. To pick up any unhandled exceptions in a thread, we can do:

```
threadWithError.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {  
    @Override  
    public void uncaughtException(Thread t, Throwable e) {  
        System.out.println("ERROR " + t.getName() + " - " + e.getMessage());  
    }  
});
```
###### Daemon Threads
Threads that does not prevent the program in closing. It is usually some background task
An example could be a thread in a text-editer that saves to file. 