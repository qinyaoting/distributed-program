package test18.map;

import com.google.common.collect.ArrayListMultimap;
import org.apache.commons.collections.MultiHashMap;
import org.apache.commons.collections.MultiMap;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/28/18
 * Time: 2:18 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ArrayListMultimapTest {

    public static void main(String[] args) {

        // Map<Author>, List<Book>> 类似的结构
        // 可以用MultiMap来保存, 要比上述结构简洁
        ArrayListMultimap multimap = ArrayListMultimap.create();
        multimap.put("jack","book-1");
        multimap.put("jack","book-2");
        multimap.put("jack","book-3");

        System.out.println(multimap.toString());
        Object obj = multimap.get("jack");

        /*multiMap.put("lucy", null);
        multiMap.put("lucy", "book-b");
        multiMap.put("lucy", "book-c");
        System.out.println(multiMap.toString());
        Object obj2 = multiMap.get("lucy");

        // 查找不存在的key
        Object obj3 = multiMap.get("ken");
        System.out.println(obj3);

        // 删除某个key对应的item
        multiMap.remove("lucy","book-c");
        System.out.println(multiMap.toString());

        // 删除不存在的key, 不会报错
        multiMap.remove("ken");
        // 删除不存在的key下的item, 不会报错
        multiMap.remove("ken","book-c");
        System.out.println(multiMap.toString());*/

    }
}
