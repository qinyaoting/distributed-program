package test29;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"test30"})
@EnableAutoConfiguration
public class BootApp {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootApp.class, args);
    }
}
