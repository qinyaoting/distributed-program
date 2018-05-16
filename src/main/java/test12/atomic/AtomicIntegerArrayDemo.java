package test12.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * Created by chin on 7/26/15.
 */
public class AtomicIntegerArrayDemo {

    static AtomicIntegerArray arr = new AtomicIntegerArray(10);

    //原子数组初始中含有10个0, 线程给原子数组每个元素进行加一, 10个线程同时进行
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
        System.out.println("i: " + arr  );
    }



    static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int j = 0; j < 100000; j++) {
                arr.getAndIncrement(j%arr.length());
            }
        }
    }
}


