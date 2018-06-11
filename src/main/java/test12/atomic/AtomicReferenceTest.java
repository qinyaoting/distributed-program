package test12.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by chin on 9/23/15.
 */
public class AtomicReferenceTest {

    public static final AtomicReference<String> atomicStr = new AtomicReference<String>("abc");

    // 10个线程,同时修改'abc', 看能否多个线程会同时修改, 结果是只有一个线程可以修改成功
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int num = i;
            new Thread() {
                @Override
                public void run() {
                    try {
                        TimeUnit.MILLISECONDS.sleep(Math.abs((int)Math.random()*100));
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                    if (atomicStr.compareAndSet("abc","def")) {
                        System.out.println(Thread.currentThread().getId() + " change value succ");
                    } else {
                        System.out.println(Thread.currentThread().getId() + " change failed");
                    }
                }
            }.start();
        }
    }
}
