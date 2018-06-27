package test54.yml2bean;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.google.common.collect.Lists;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DemoService {

    public void yml2Bean() throws IOException {
        ClassLoader loader = getClass().getClassLoader();
        String path = loader.getResource("settings.yml").getPath();

        YamlWriter w = new YamlWriter(new FileWriter((path)));

        Demo d1 = new Demo("p1","p1----");

        Demo d2 = new Demo("c2", "c2------");
        Demo d3 = new Demo("c3", "c3------");
        d1.setItems(Lists.newArrayList(d2,d3));
        w.write(d1);

        // 空的TODO
        /*YamlReader reader = new YamlReader(new FileReader(path));
        Demo demo = reader.read(Demo.class);
        System.out.println(demo);*/

    }
}
