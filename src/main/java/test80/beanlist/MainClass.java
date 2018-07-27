package test80.beanlist;

import com.google.common.collect.Lists;
import test14.guava.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/27/18
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    // 保存对象到一个list中, 需要根据对象的某个属性做为判断是否重复的条件, 条件重复的对象不放进去

    public static void main(String[] args) {

        Person p1 = new Person(1,"tom",22.2);
        Person p2 = new Person(2,"lucy",11.3);
        Person p3 = new Person(3,"ken",88.2);
        Person px = new Person(1,"tomcat",88.2);//id重复, 不会保存到list中

        // 方法1
        //List ll = saveIntoList(p1,p2,p3,px);
        //System.out.println(ll.size());
        // 方法2
        betterSaveIntoList(p1,p2,p3,px);

    }

    public static List<Person> saveIntoList(Person... ps) {
        List<Person> list = Lists.newArrayList();
        for(Person per: ps) {
            if (!list.contains(per))     //Person equal
                list.add(per);
        }
        return list;
    }

    public static List<Person> betterSaveIntoList(Person... ps) {
        List<Person> l =
                Arrays.stream(ps)
                        .filter(distinctByKey(p->p.id))
                        .collect(Collectors.toList());
        return l;
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }


}
