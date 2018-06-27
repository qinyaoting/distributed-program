package test54.yml2bean;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 2:37 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DemoMainClass {


    // 如何从yaml文件中初始化为对象

    public static void main(String[] args) throws IOException {
        DemoService service = new DemoService();
        service.yml2Bean();
        System.out.println("end");
    }



}
