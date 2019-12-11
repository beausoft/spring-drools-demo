package cn.beausoft.test.spring.drools;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ImportResource("classpath:drools-config.xml")
public class SpringDroolsApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder(SpringDroolsApp.class).run(args);
    }

}
