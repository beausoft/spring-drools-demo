package cn.beausoft.test.spring.drools.controller;

import cn.beausoft.test.spring.drools.model.User;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
//    @KContainer
//    private KieContainer kContainer;
//    @KBase("testRules")
//    private KieBase kbase;
//    @KSession("ksession1")
//    private StatelessKieSession ksession1;
    @Autowired
    private ApplicationContext applicationContext;

    @GetMapping("/hello")
    public Map<String, Object> helloWorld() {
        Map<String, Object> data = new HashMap<>();
        data.put("msg", "Hello World");
        return data;
    }

    @GetMapping("/testUser")
    public User testUser() {
        KieSession ksession2 = applicationContext.getBean("ksession2", KieSession.class);
        try {
            User user = new User();
            user.setUsername("han");
            user.setName("aaa");
            user.setAge(18);
            ksession2.insert(user);
            int a = ksession2.fireAllRules();
            System.out.println(a);
            return user;
        } finally {
            ksession2.dispose();
        }
    }

}
