package org.example.exercises;
import java.util.List;

/**
 *
 Thread Creation - MultiExecutor
 In this exercise, we are going to implement a  MultiExecutor .

 The client of this class will create a list of Runnable tasks and provide that list into MultiExecutor's constructor.

 When the client runs the  executeAll(),  the MultiExecutor,  will execute all the given tasks.

 To take full advantage of our multicore CPU, we would like the MultiExecutor to execute all the tasks in parallel by passing each task to a different thread.

 Please implement the MultiExecutor below
 */

public class MultiExecutor {

    // Add any necessary member variables here
    List<Runnable> tasks;

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        tasks.forEach(task -> {
            Thread thread = new Thread(task);
            thread.start();
        });
    }
}