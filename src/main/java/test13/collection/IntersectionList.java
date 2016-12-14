package test13.collection;


import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * Created by chin on 12/8/16.
 */
public class IntersectionList {


    /**
     * 先根据是否自增筛选,在筛选name=a开头的
     * @param args
     */
    public static void main(String[] args) {
        Column a1 = new Column();
        a1.setName("a1");
        a1.setAutoIncrement(true);
        Column a2 = new Column();
        a2.setName("a2");
        a2.setAutoIncrement(false);
        Column a3 = new Column();
        a3.setName("a3");
        a3.setAutoIncrement(true);


        List<Column> list = Lists.newArrayList();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        //=================


        Column c1 = new Column();
        c1.setName("a1");
        c1.setAutoIncrement(true);
        Column c2 = new Column();
        c2.setName("c2");
        c2.setAutoIncrement(false);
        Column c3 = new Column();
        c3.setName("c3");
        c3.setAutoIncrement(true);


        List<Column> list2 = Lists.newArrayList();
        list2.add(c1);
        list2.add(c2);
        list2.add(c3);

        List result = (List) CollectionUtils.intersection(list,list2);
        System.out.println(result);

        // 并集
        /*Collection<String> unionList = CollectionUtils.union(aList, bList);
        // 交集
        Collection<String> intersectionList = CollectionUtils.intersection(aList, bList);
        // 是否存在交集
        boolean isContained = CollectionUtils.containsAny(aList, bList);
        // 交集的补集
        Collection<String> disjunctionList = CollectionUtils.disjunction(aList, bList);
        // 集合相减
        Collection<String> subtractList = CollectionUtils.subtract(aList, bList);

        // 排序
        Collections.sort((List<String>) unionList);
        Collections.sort((List<String>) intersectionList);
        Collections.sort((List<String>) disjunctionList);
        Collections.sort((List<String>) subtractList);*/


    }


}
