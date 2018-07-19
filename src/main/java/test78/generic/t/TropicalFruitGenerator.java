package test78.generic.t;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/19/18
 * Time: 3:05 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TropicalFruitGenerator implements Generator<String> {  //实现了接口, 并指定接口类型为String


    private String[] fruits = new String[]{"Litchi", "Banana", "Mango"};

    @Override
    public String next() {          //方法自动变为String
        Random rad = new Random();
        return fruits[rad.nextInt(3)];
    }
}
