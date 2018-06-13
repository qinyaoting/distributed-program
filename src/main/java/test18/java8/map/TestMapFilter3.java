package test18.java8.map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 6/13/18
 * Time: 6:27 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestMapFilter3 {

    // Generic Map filterbyvalue, with predicate
    public static <K, V> Map<K, V> filterByValue(Map<K, V> map, Predicate<V> predicate) {
        return map.entrySet()
                .stream()
                .filter(x -> predicate.test(x.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public static void main(String[] args) {

        Map<Integer, String> HOSTING = new HashMap<>();
        HOSTING.put(1, "linode.com");
        HOSTING.put(2, "heroku.com");
        HOSTING.put(3, "digitalocean.com");
        HOSTING.put(4, "aws.amazon.com");
        HOSTING.put(5, "aws2.amazon.com");

        //  {1=linode.com}
        Map<Integer, String> filteredMap = filterByValue(HOSTING, x -> x.contains("linode"));
        System.out.println(filteredMap);

        // {1=linode.com, 4=aws.amazon.com, 5=aws2.amazon.com}
        Map<Integer, String> filteredMap2 = filterByValue(HOSTING, x -> (x.contains("aws") || x.contains("linode")));
        System.out.println(filteredMap2);

        // {4=aws.amazon.com}
        Map<Integer, String> filteredMap3 = filterByValue(HOSTING, x -> (x.contains("aws") && !x.contains("aws2")));
        System.out.println(filteredMap3);

        // {1=linode.com, 2=heroku.com}
        Map<Integer, String> filteredMap4 = filterByValue(HOSTING, x -> (x.length() <= 10));
        System.out.println(filteredMap4);

    }

}
