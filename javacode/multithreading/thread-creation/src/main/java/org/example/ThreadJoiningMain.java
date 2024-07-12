package org.example;

import java.util.ArrayList;
import java.util.List;

public class ThreadJoiningMain {

    public static void main(String[] args){
        List<Integer> sleepTimers = List.of(1000, 5000, 6000, 10000, 1);
        List<Thread> threads = new ArrayList<>();

        sleepTimers.forEach(sleepTimer -> {
            threads.add(new WaiterThread(sleepTimer));
        });

        threads.forEach(Thread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });



        System.out.println("Main thread done");
    }

    public static class WaiterThread extends Thread {

        private int sleepTimer;

        public WaiterThread(int sleepTimer){
            this.sleepTimer = sleepTimer;
        }

        @Override
        public void run(){
            try {
                sleep(sleepTimer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread with timer " + sleepTimer + " is done");
        }
    }
}
