package test54.yml2bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/7/18
 * Time: 2:36 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Demo {

    private String name;
    private String desc;

    private List<Demo> items;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Demo> getItems() {
        return items;
    }

    public void setItems(List<Demo> items) {
        this.items = items;
    }


    public Demo(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
}
