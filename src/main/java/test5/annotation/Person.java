package test5.annotation;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/6/18
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Person {

    public int id;
    public String name;

    public Person() {
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private Person mirror = new Person(100,"mirror");

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

    public Person getMirror() {
        return mirror;
    }

}
