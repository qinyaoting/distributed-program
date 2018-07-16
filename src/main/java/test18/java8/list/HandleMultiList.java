package test18.java8.list;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/16/18
 * Time: 5:20 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class HandleMultiList {

    public static void main(String[] args) {

        // 同时便利两个list
        List<Integer> list1 = Lists.newArrayList(1,2,3,4);
        List<Integer> list2 = Lists.newArrayList(5,6,7,8);

        Stream.of(list1,list2)
                .flatMap(n->n.stream())
                .filter(n->n%2==0)
                .forEach(System.out::println);
    }
}
