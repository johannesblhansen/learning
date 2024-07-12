package org.example;

public class ThreadCreationMain {

//    Logger logger = Logger.getLogger();

    public static void main(String[] args) {
        System.out.println("Hello From Thread " + Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            System.out.println("Hello From Thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello From Thread after sleep " + Thread.currentThread().getName());
        });
        thread.setName("MyThreadName");
        thread.setPriority(Thread.MAX_PRIORITY); //Telling the scheduler what priority we want it to use

        Thread threadWithError = new Thread(() -> {
            System.out.println("Hello From Thread " + Thread.currentThread().getName());
            throw new RuntimeException("Error from thread");
        });
        threadWithError.setName("ErrorProneThread");
        threadWithError.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("ERROR " + t.getName() + " - " + e.getMessage());
            }
        });

        thread.start();
        threadWithError.start();
        System.out.println("Hello From Thread " + Thread.currentThread().getName());
    }

}