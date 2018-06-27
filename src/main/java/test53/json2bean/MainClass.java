package test53.json2bean;

import com.esotericsoftware.yamlbeans.YamlReader;
import com.esotericsoftware.yamlbeans.YamlWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import test54.yml2bean.Demo;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        Zoo zoo = new Zoo("SH wild park", "Shanghai");
        Lion lion = new Lion("Samba");
        lion.sex = "F";
        Elephant elephant = new Elephant("Manny");
        elephant.high = "10";
        List<Animal> animals = new ArrayList<Animal>();
        animals.add(lion);
        animals.add(elephant);
        zoo.setAnimals(animals);
        /*ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.writeValue(new File("zoo.json"), zoo);

        Zoo zoo2 = mapper.readValue(new File("zoo.json"), Zoo.class);
        System.out.println(zoo2);*/


        //ClassLoader loader = getClass().getClassLoader();
        //String path = loader.getResource("settings.yml").getPath();
        YamlWriter w = new YamlWriter(new FileWriter("zoo.yml"));
        w.write(zoo);
        /*YamlReader reader = new YamlReader(new FileReader("zoo.yml"));
        Demo demo = reader.read(Demo.class);
        System.out.println(demo);*/

    }
}
