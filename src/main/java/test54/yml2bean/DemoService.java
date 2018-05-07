package test54.yml2bean;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DemoService {

    public void yml2Bean() throws YamlException, FileNotFoundException {
        ClassLoader loader = getClass().getClassLoader();
        String path = loader.getResource("settings.yml").getPath();
        YamlReader reader = new YamlReader(new FileReader(path));
        Demo demo = reader.read(Demo.class);
        System.out.println(demo);

    }
}
