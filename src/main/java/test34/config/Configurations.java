package test34.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/9/17
 * Time: 3:42 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@Component
@PropertySource("classpath:default.properties")
public class Configurations {

    @Value("${test.name}")      //34-1
    private String name;

    @Value("${test.age}")
    private int age;

    @Value("${test.tel}")
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
