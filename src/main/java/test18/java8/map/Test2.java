package test18.java8.map;

import com.google.common.collect.Streams;
import org.springframework.boot.json.JsonSimpleJsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/16/18
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Test2 {

    public static void main(String[] args) {

        MyObject obj1 = new MyObject("a");
        MyObject obj2 = new MyObject("b");
        MyObject obj3 = new MyObject("c");

        List<MyObject> list1 = Arrays.asList(obj1, obj2, obj3);
        List<Boolean> list2 = Arrays.asList(true, false, true);
        List<MyObject> list = new ArrayList<>();
        for(int i=0; i<list1.size();i++) {
            if(list2.get(i))
                list.add(list1.get(i));
        }
        list.forEach(System.out::println);


        List<MyObject> lists = IntStream.range(0,list1.size())
                .filter(i->list2.get(i))
                .mapToObj(list1::get)
                .collect(Collectors.toList());
        lists.forEach(System.out::println);

        // a是true就返回b, a是false就返回null
        List<MyObject> lists2 = Streams.zip(list2.stream(), list1.stream(), (a,b) -> a ? b : null)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        lists2.forEach(System.out::println);
    }

    static class MyObject {
        public String name;

        public MyObject(String name) {
            this.name = name;
        }


    }
}
