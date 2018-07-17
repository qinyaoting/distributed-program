package test18.java8.map;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/16/18
 * Time: 6:07 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ForeachMapList {


    public static void main(String[] args) {

        Map<String,String> map = ImmutableMap.of("apple","code1","pear","code2","orange","code3");


        List list = Lists.newArrayList(
                new Fruit("code1","10"),
                new Fruit("code2","20"),
                new Fruit("code3","30"),
                new Fruit("code4","40")
        );
        Stream.of(map, list)
                .forEach(System.out::println);

        /*map.keySet().stream()
                .map(item->map.get(item))
                .collect(Collectors.toList());*/
    }




    // expect map apple-value

    static class Fruit {

        public String code;
        public String value;

        public Fruit(String code, String value) {
            this.code = code;
            this.value = value;
        }
    }


}





