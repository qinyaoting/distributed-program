package test18.java8.optional;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 6/20/18
 * Time: 6:32 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass4 {

    public static void main(String[] args) {


        Optional<Integer> op1 = Optional.ofNullable(1);
        Optional<Integer> op2 = Optional.ofNullable(null);

        System.out.println(op1.isPresent());    //true
        System.out.println(op2.isPresent());    //false

        op1.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("value:" + integer);
            }
        });

        // 不会调用accept
        op2.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("value:" + integer);
            }
        });

    }
}
