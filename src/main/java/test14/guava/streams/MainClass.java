package test14.guava.streams;




import com.google.common.collect.Streams;
import javafx.util.Pair;
import org.springframework.data.util.StreamUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/17/18
 * Time: 11:22 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {


    public static void main(String[] args) {


        List<String> subjectArr = Arrays.asList("aa", "bb", "cc");
        List<Long> numArr = Arrays.asList(2L, 6L, 4L);
        List<Pair> pairs = Streams.zip(subjectArr.stream(), numArr.stream(), Pair::new)
                .collect(Collectors.toList());

        System.out.println(pairs);

        // 第二部分
        Stream<String> streamA = Stream.of("A","B","C");
        Stream<String> streamB = Stream.of("Apple", "Banana", "Carrot", "Doughnut");
        /*XXX
        List<Person> people = Streams.zip(subjectArr.stream(), numArr.stream(), Person::new)
                .collect(Collectors.toList());

        System.out.println(people);*/


    }

    /*xxx
    public static <A,B> List<Pair<A,B>> zipJava8(List<A> as, List<B> bs) {

        return IntStream.range(0, Math.min(as.size(), bs.size()))
                .mapToObj(i-> new Pair(as.get(i), bs.get(i)))
                .collect(Collectors.toList());
    }*/




    class A {

    }

    class B {

    }

    class Person {
        public String name;
        public int age;


        public <A, B> Person(A a, B b) {

        }
    }
}
