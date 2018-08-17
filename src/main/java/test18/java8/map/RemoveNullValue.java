package test18.java8.map;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.PredicateUtils;

import java.util.Collections;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 8/17/18
 * Time: 6:26 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class RemoveNullValue {

    /**
     * 如何删除map中value是空的值
     * @param args
     */
    public static void main(String[] args) {

        Map map = Maps.newHashMap();
        map.put("a",1);
        map.put("b","tom");
        map.put("c",null);
        map.put("d",3.4f);

        //Iterables.removeIf(map.values(), Predicates.isNull());
        Iterables.removeIf(map.values(), x->x == null);
        System.out.println(map);

        map.clear();
        map.put("a",1);
        map.put("b","tom");
        map.put("c",null);
        map.put("d",3.4f);

        //CollectionUtils.filter(map.values(), PredicateUtils.notNullPredicate());
        CollectionUtils.filter(map.values(), x->x != null);
        System.out.println(map);

        map.clear();
        map.put("a",1);
        map.put("b","tom");
        map.put("c",null);
        map.put("d",3.4f);

        map.values().removeAll(Collections.singleton(null));
        System.out.println(map);
    }
}
