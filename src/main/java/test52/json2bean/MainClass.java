package test52.json2bean;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/4/18
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        File jsonF =  ResourceUtils.getFile("classpath:company.json");  //读取resources下的文件
        Company company = mapper.readValue(jsonF, Company.class);
        System.out.println(company.toString());
    }
}
