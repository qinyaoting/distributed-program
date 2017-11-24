package test12.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by chin on 11/30/16.
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        ExecutorService executors= Executors.newFixedThreadPool(20);
        final Semaphore semaphore=new Semaphore(5);

        for(int i=0;i<20;i++){
            final int n=i;
            new Thread(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(n);
                    semaphore.release();
                }
            }).start();
        }

    }
}
