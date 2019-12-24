package cn.beausoft.test.spring.drools;

import org.drools.compiler.kie.builder.impl.InternalKieModule;
import org.kie.api.builder.model.KieModuleModel;
import org.kie.spring.annotations.KModuleAnnotationPostProcessor;
import org.springframework.stereotype.Component;

@Component("kieAnnotationPostProcessor")
public class SpringJarKModuleAnnotationPostProcessor extends KModuleAnnotationPostProcessor {

    @Override
    protected InternalKieModule createKieModule(KieModuleModel kieProject) {
        return new ClasspathKieModule(releaseId, kieProject);
    }
}
