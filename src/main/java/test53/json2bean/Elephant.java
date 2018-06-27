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
public class Elephant extends Animal {

    private String name;

    public String high;

    @JsonCreator
    public Elephant(@JsonProperty("name")String name) {
        this.name = name;
        super.type = "elephant";
    }
    public String getName() {
        return name;
    }

    /*public String getType() {
        return "herbivorous";
    }*/

    @Override
    public String toString() {
        return "Elephant [getName()=" + getName() + ", getType()="/* + getType()
                + "]"*/;
    }
}
