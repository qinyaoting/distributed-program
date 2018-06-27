package test53.json2bean;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.*;


/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 4:52 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY,property = "type", visible = true)       //3.??
@JsonSubTypes({@Type(value=Lion.class, name="lion"),
        @Type(value=Elephant.class,name="elephant")})       //2.标记了两个子类
public abstract class Animal {

    String name;
    String type;
}
