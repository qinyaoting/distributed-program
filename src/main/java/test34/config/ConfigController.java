package test34.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/9/17
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private Configurations configurations;  //34-3

    @GetMapping("/param")
    public Map config() {
        Map result = new HashMap();
        result.put("name", configurations.getName());
        result.put("age", configurations.getAge());
        result.put("tel", configurations.getTel());
        return result;       //34-4
    }
}
