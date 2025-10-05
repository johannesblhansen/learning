package dk.johannes.show_notifications_frontend.generator;

import org.springframework.stereotype.Component;

@Component
public class GeneratorStarterComponent {

    public GeneratorStarterComponent(){
        Thread thread = new Thread(new MyRunnable(), "GeneratorThread");
        thread.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(5_000);
                System.out.println("We are in the thread");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
