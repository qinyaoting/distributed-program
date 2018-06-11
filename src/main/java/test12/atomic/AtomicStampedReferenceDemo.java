package test12.atomic;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Created by chin on 9/23/15.
 */
public class AtomicStampedReferenceDemo {

    static AtomicStampedReference<Integer> money = new AtomicStampedReference<Integer>(19,0);

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            final int timestamp = money.getStamp();
            new Thread() {
                @Override
                public void run() {
                    while (true) {
                        while (true) {
                            Integer m = money.getReference();
                            if (m < 20) {
                                if (money.compareAndSet(m,m+10,timestamp,timestamp+1))
                                {
                                    System.out.println("余额小于20，充值成功，当前余额"+money.getReference());
                                    break;
                                } else
                                    break;
                            }
                        }
                    }
                }
            }.start();
        }
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    while(true) {
                        int timestamp = money.getStamp();
                        Integer m = money.getReference();
                        if (m > 10) {
                            System.out.println("大于10");
                            if (money.compareAndSet(m,m-10,timestamp,timestamp+1)) {
                                System.out.println("消费10 余额是:"+money.getReference());
                                break;
                            }
                        } else {
                            System.out.println("没有足够的金额");
                            break;
                        }
                        try {
                            TimeUnit.MILLISECONDS.sleep(100);
                        } catch (InterruptedException e) {

                        }
                    }
                }
            }
        }.start();
    }
}
