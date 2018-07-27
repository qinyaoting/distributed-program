package test77.intstream;

import com.google.common.primitives.Ints;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/14/18
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {
        //IntStream.of(1,2,3).forEach(System.out::println);

        // 1-2
        //IntStream.range(1,3).forEach(System.out::println);

        // 1-5 包括右边界
        // IntStream.rangeClosed(1,5).forEach(System.out::println);

        // 0 2 4
        //IntStream.iterate(0,i->i+2).limit(3).forEach(System.out::println);

        //IntStream.generate(()->ThreadLocalRandom.current().nextInt(10)).limit(3).forEach(System.out::println);

        // 1 2 3 4 的平方
        IntStream.range(1,5).map(i->i*i).forEach(System.out::println);


        //
        //Stream<Color> stream = IntStream.range(1,5).mapToObj(i->getColor(i));

        //Stream<Integer> str = IntStream.range(1,5).boxed();

        DoubleStream ds = IntStream.range(1,5).mapToDouble(i->i);
        //ds.forEach(System.out::println);

        LongStream ls = IntStream.range(1,5).mapToLong(i->i);
        //ls.forEach(System.out::println);

        //
        System.out.println(IntStream.range(1,5).anyMatch(i->i%2==0));
        // 全部都能整除2
        // System.out.println(IntStream.range(1,5).allMatch(i->i%2==0));
        // System.out.println(IntStream.range(1,5).noneMatch(i->i%2==0));


        boolean b1 = IntStream.range(1,5).filter(i->i%2==0)
                .allMatch(i->i%2==0);
        System.out.println(b1);

        boolean b2 = IntStream.range(1,5)
                .filter(i->i%2==0)
                .noneMatch(i->i%2!=0);
        System.out.println(b2);

        int max = IntStream.range(1,5).max().getAsInt();
        System.out.println(max);

        int min = IntStream.range(1,5).min().getAsInt();
        System.out.println(min);

        int sum = IntStream.range(1,5).reduce(1,(x,y)->x*y);
        System.out.println(sum);

    }

    public static Color getColor(int i) {
        return Color.BLACK;
    }
}
