package test12.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by chin on 7/26/15.
 */
public class AtomicIntegerTest {

    static AtomicInteger i = new AtomicInteger();
    static int count;


    // 创建10个线程, 同时给两个共享变量进行加一操作
    // AtomicInteger的变量线程安全,
    // 结论是Atomic在线程直接可以共享变量

    public static void main(String[] args) throws InterruptedException {

        Thread[] ts = new Thread[10];
        for (int j = 0; j <10 ; j++) {
            ts[j] = new Thread(new AddThread());
        }

        for (int j = 0; j < 10; j++) {
            ts[j].start();                  // 启动10个线程，每个线程对i加10000
        }

        for (int j = 0; j < 10; j++) {
            ts[j].join();
        }
        System.out.println("i: " + i);
        System.out.println("c: " + count);
    }



    static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                i.incrementAndGet();
                count ++;
            }
        }
    }
}


