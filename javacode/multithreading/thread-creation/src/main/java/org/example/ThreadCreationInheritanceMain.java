package org.example;

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
