package Chapter06;

import java.util.concurrent.TimeUnit;

public class ThreadGroupInterrupt {

    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("TestGroup");
        new Thread(group, () ->
        {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t1 will exit");
        }, "t1").start();

        new Thread(group, () ->
        {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    break;
                }
            }
            System.out.println("t2 will exit");
        }, "t2").start();

        TimeUnit.SECONDS.sleep(2);
        group.interrupt();
    }
}
