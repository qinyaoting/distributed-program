package test12.concurrent;

import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 11/24/17
 * Time: 6:18 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class SemaphoreTest2 {

    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i=0;i<N;i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {

        Semaphore semaphore;

        int num;

        public Worker(int num, Semaphore se) {
            this.num = num;
            this.semaphore = se;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一个机器在生产...");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放出机器");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
