package test34.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/9/17
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Component
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:default.properties")
public class Configuration {

    private String name;

    private int age;
    private Long tel;

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

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }
}
