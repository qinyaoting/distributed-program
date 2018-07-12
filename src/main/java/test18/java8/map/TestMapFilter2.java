package test18.java8.map;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 6/13/18
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TestMapFilter2 {

    public static void main(String[] args) {

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");

        //Map -> Stream -> Filter -> Map
        Map<Integer, String> collect = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() == 2)
                .collect(Collectors.toMap(p -> p.getKey(), p -> p.getValue()));     //java8构造map返回

        System.out.println(collect); //output : {2=heroku.com}

        Map<Integer, String> collect2 = HOSTING.entrySet().stream()
                .filter(map -> map.getKey() <= 3)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(collect2); //output : {1=linode.com, 2=heroku.com, 3=digitalocean.com}

    }

}
