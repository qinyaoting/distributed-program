package test12.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by chin on 11/30/16.
 *
 * http://blog.csdn.net/cyantide/article/details/50947810
 */
public class Test {


    static Integer count=1;

    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(10);
//      final CyclicBarrier cyclicBarrier=new CyclicBarrier(5);
        final CyclicBarrier cyclicBarrier=new CyclicBarrier(5,new Runnable(){
            public void run() {
                System.out.println("已经赚了"+(Test.count++)+"元");

            }

        });


        Thread thread1=new Thread(new Runnable(){
            public void run() {
                System.out.println("点一下");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });

        for(int i=0;i<50;i++){
            executor.execute(thread1);
        }
    }
}
