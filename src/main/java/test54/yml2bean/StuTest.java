package test54.yml2bean;

import org.yaml.snakeyaml.Yaml;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 4:35 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class StuTest {


    // snakeyaml生成yaml不太好,
    // 生成的yaml还有{}

    public static void main(String[] args) throws IOException {
        Student stu=new Student();
        stu.setName("路飞");
        stu.setAge(24);
        stu.setId(1);
        Tel t=new Tel();
        t.setName("张三");
        t.setTel("10123041445");
        Tel t1=new Tel();
        t1.setName("李四");
        t1.setTel("19923041455");
        List<Tel> tels=new ArrayList<Tel>();
        tels.add(t);
        tels.add(t1);
        stu.setTels(tels);
        Yaml yaml = new Yaml();
        yaml.dump(stu, new FileWriter("stu.yaml"));
    }
}
