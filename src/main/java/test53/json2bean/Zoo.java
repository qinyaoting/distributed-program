package test53.json2bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Zoo {

    public String name;
    public String city;
    public List<Animal> animals;    //1. Animal是个抽象类

    @JsonCreator
    public Zoo(@JsonProperty("name")String name,
               @JsonProperty("city")String city) {
        this.name = name;
        this.city = city;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", animals=" + animals +
                '}';
    }
}
