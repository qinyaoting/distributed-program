package test54.yml2bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 4:33 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Student {

    private int id;
    private String name;
    private int age;

    List<Tel> tels = new ArrayList<Tel>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Tel> getTels() {
        return tels;
    }

    public void setTels(List<Tel> tels) {
        this.tels = tels;
    }
}
