package test54.yml2bean;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ContactService {

    // 读取yaml文件, 转换为Map结构
    public void readYamlFile() throws FileNotFoundException, YamlException {
        ClassLoader loader = getClass().getClassLoader();
        String path = loader.getResource("contact.yml").getPath();
        YamlReader reader = new YamlReader(new FileReader(path));
        Object obj = reader.read();
        System.out.println(obj);

        Map map = (Map)obj;
        System.out.println(map.get("address"));
    }

    // 读取yaml中的多个对象, 包含多个对象时, 对象之间用---分割
    public void readYamlFile2() throws FileNotFoundException, YamlException {
        ClassLoader loader = getClass().getClassLoader();
        String path = loader.getResource("contact-with_mul_obj.yml").getPath();
        YamlReader reader = new YamlReader(new FileReader(path));
        while (true) {
            Map contact = (Map) reader.read();
            if (contact == null) break;
            System.out.println(contact.get("age"));
        }
    }
}
