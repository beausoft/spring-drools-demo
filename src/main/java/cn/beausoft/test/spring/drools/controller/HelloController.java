package cn.beausoft.test.spring.drools.controller;

import cn.beausoft.test.spring.drools.entity.User;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {
    @KContainer
    private KieContainer kContainer;
    @KBase("testRules")
    private KieBase kbase;
    @KSession("ksession1")
    private StatelessKieSession ksession1;
    @KSession("ksession2")
    private KieSession ksession2;

    @GetMapping("/hello")
    public Map<String, Object> helloWorld() {
        Map<String, Object> data = new HashMap<>();
        data.put("msg", "Hello World");
        return data;
    }

    @GetMapping("/testUser")
    public User testUser() {
        User user = new User();
        user.setUsername("han");
        user.setName("韩");
        user.setAge(18);
        ksession2.insert(user);
        int a = ksession2.fireAllRules();
        return user;
    }

}
