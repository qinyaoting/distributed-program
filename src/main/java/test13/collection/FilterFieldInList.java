package test13.collection;


import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;

import java.util.Collection;
import java.util.List;

/**
 * Created by chin on 12/8/16.
 */
public class FilterFieldInList {


    /**
     * https://www.oschina.net/code/snippet_176115_13674
     * 集合有许多对象,取对象的某个字段构成集合
     * @param args
     */
    public static void main(String[] args) {
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

        List<String> names = (List<String>)CollectionUtils.collect(list,new Transformer() {
            @Override
            public Object transform(Object input) {

                Column cl = (Column)input;
                return cl.getName();
            }
        });



        System.out.println(names);
    }


}
