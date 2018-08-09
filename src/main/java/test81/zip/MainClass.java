package test81.zip;

import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/30/18
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>(Arrays.asList("John", "Jane", "Jack", "Dennis"));
        List<Integer> ages = new ArrayList<>(Arrays.asList(24, 25, 27));
        //first
        Stream<String> ss = IntStream.range(0, Math.min(names.size(),ages.size()))
                .mapToObj(i->names.get(i)+ ":" + ages.get(i));
        System.out.println(ss);

        //second
        Stream<String> sss = Streams.zip(names.stream(), ages.stream(), (name,age) ->name+""+age);
        System.out.println(sss);

        //Third

    }
}
