package test13.collection;


import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by chin on 12/8/16.
 */
public class Test {


    /**
     * 集合有许多对象,可能需要按对象的某个字段进行过滤该集合
     * @param args
     */
    public static void main(String[] args) {
        getAutoIncrementColumns();
    }


    public static Column[] getAutoIncrementColumns()
    {

        Column c1 = new Column();
        c1.setName("c1");
        c1.setAutoIncrement(true);
        Column c2 = new Column();
        c2.setName("c2");
        c2.setAutoIncrement(false);
        Column c3 = new Column();
        c3.setName("c3");
        c3.setAutoIncrement(true);


        List<Column> list = Lists.newArrayList();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        Collection autoIncrColumns = CollectionUtils.select(list, input -> ((Column) input).isAutoIncrement());


        System.out.println(autoIncrColumns);

        return (Column[])autoIncrColumns.toArray(new Column[autoIncrColumns.size()]);
    }
}
