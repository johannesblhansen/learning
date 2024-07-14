package org.example;

public class ForcingIncrementErrorSynchronizedBlock {
    public static void main(String[] args) throws InterruptedException {
        Incrementer incrementer = new Incrementer();
        AddingThread addingThread = new AddingThread(incrementer);
        SubtractingThread subtractingThread = new SubtractingThread(incrementer);
        addingThread.start();
        subtractingThread.start();

        addingThread.join();
        subtractingThread.join();

        System.out.println(incrementer.getCounter());
    }

    public static class Incrementer {
        private int counter;
        final Object lock1 = new Object();
        public void increment() {
            synchronized (lock1) {
                counter++; //non-atomic operation. This is not safe
            }
        }

        public void subtract() {
            synchronized (lock1) {
                counter--; //non-atomic operation. This is not safe
            }
        }

        public int getCounter() {
            return counter;
        }
    }

    public static class AddingThread extends Thread {

        private final Incrementer incrementer;

        public AddingThread(Incrementer incrementer) {
            this.incrementer = incrementer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                incrementer.increment();
            }
        }
    }

    public static class SubtractingThread extends Thread {

        private final Incrementer incrementer;

        public SubtractingThread(Incrementer incrementer) {
            this.incrementer = incrementer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                incrementer.subtract();
            }
        }
    }
}