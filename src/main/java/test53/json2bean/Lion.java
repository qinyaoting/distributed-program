package test53.json2bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 4:57 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Lion extends Animal {

    private String name;

    public String sex;

    @JsonCreator
    public Lion(@JsonProperty("name")String name) {
        super.type = "lion";
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /*public String getType() {
        return "carnivorous";
    }*/

    @Override
    public String toString() {
        return "Lion [name=" + name + ", getName()=" + getName()
                /*+ ", getType()=" + getType() + "]"*/;
    }
}
