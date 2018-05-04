package test52.json2bean;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Department {

    private String name;
    private String pm;
    private Map<String,Object> otherProperties = new HashMap<String,Object>();

    @JsonCreator
    public Department(@JsonProperty("name") String name) {
        this.name = name;
    }

    @JsonProperty("projectManager")     //将json中的projectManager关联到该方法
    public String getPm() {
        return pm;
    }

    public String getName() {
        return name;
    }

    public Object get(String key) {
        return otherProperties.get(key);
    }

    @JsonAnyGetter      //得到所有Department中未定义的json字段的
    public Map<String, Object> any() {
        return otherProperties;
    }

    @JsonAnySetter
    public void set(String key, Object val) {
        otherProperties.put(key, val);
    }


}
