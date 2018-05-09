package test18.stream.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/9/18
 * Time: 1:44 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {

        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);

        // 旧的便利方法
        for (Map.Entry<String,Integer> entry : items.entrySet()){
            System.out.println("key:"+entry.getKey()+";value:"+entry.getValue());
        }

        //新的
        items.forEach((k,v)->System.out.printf("k:%s v:%s", k,v));


        items.forEach((k,v)->{
            System.out.println("k:"+k+"v:"+v);
            if ("E".equals(k)) {
                System.out.println("hello");
            }
        });


    }
}
