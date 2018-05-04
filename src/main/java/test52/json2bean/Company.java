package test52.json2bean;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 3:58 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Company {

    private String name;

    @JsonProperty("HQ")     // java对象的headquarters序列化为json时,字段名称改为HQ
    private String headquarters;

    private Department[] departments;

    @JsonIgnore     // 在序列号反序列化是,忽略该字段
    private Date birthDate;

    public Date getBirthDate() {
        return birthDate;
    }

    @JsonCreator
    public Company(@JsonProperty("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getHeadquarters() {
        return headquarters;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }
}
