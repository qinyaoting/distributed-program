package test54.yml2bean;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 3:01 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ContactTest {

    public static void main(String[] args) throws FileNotFoundException, YamlException {
        ContactService service = new ContactService();
        service.readYamlFile2();
    }
}
