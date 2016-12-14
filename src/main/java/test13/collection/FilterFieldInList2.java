package test13.collection;


import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.Collection;
import java.util.List;

/**
 * Created by chin on 12/8/16.
 */
public class FilterFieldInList2 {


    /**
     * 先根据是否自增筛选,在筛选name=a开头的
     * @param args
     */
    public static void main(String[] args) {
        Column c1 = new Column();
        c1.setName("a1");
        c1.setAutoIncrement(true);
        Column c2 = new Column();
        c2.setName("b2");
        c2.setAutoIncrement(false);
        Column c3 = new Column();
        c3.setName("c3");
        c3.setAutoIncrement(true);


        List<Column> list = Lists.newArrayList();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        //=================


    }


}
