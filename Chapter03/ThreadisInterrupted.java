package Chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadisInterrupted {

    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                while (true) {}
//            }
//        };
//        thread.start();
//        TimeUnit.MILLISECONDS.sleep(2);
//        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
//        thread.interrupt();
//        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());

        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        TimeUnit.MINUTES.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.printf("I am be interrupted ? %s\n", isInterrupted());
                    }
                }
            }
        };
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
        thread.interrupt();
        TimeUnit.MILLISECONDS.sleep(2);
        System.out.printf("Thread is interrupted ? %s\n", thread.isInterrupted());
    }
}
