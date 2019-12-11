package cn.beausoft.test.spring.drools.controller;

import cn.beausoft.test.spring.drools.entity.User;
import org.kie.api.KieBase;
import org.kie.api.cdi.KBase;
import org.kie.api.cdi.KContainer;
import org.kie.api.cdi.KSession;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
    @Autowired
    private ApplicationContext applicationContext; //https://docs.spring.io/spring/docs/5.2.2.RELEASE/spring-framework-reference/core.html#beans-factory-scopes-sing-prot-interaction

    @GetMapping("/hello")
    public Map<String, Object> helloWorld() {
        Map<String, Object> data = new HashMap<>();
        data.put("msg", "Hello World");
        return data;
    }

    @GetMapping("/testUser")
    public User testUser() {
        /**
         * However, suppose you want the singleton-scoped bean to
         * acquire a new instance of the prototype-scoped bean repeatedly at runtime.
         * You cannot dependency-inject a prototype-scoped bean into your singleton bean,
         * because that injection occurs only once, when the Spring container instantiates the singleton bean and
         * resolves and injects its dependencies. If you need a new instance of a prototype bean at runtime
         * more than once, see Method Injection
         */
        KieSession ksession2 = applicationContext.getBean("ksession2", KieSession.class);
        try {
            User user = new User();
            user.setUsername("han");
            user.setName("韩");
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
