package cn.beausoft.test.spring.drools;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.springframework.stereotype.Component;

@Component
public class MockRuleRuntimeEventListener implements RuleRuntimeEventListener {

    @Override
    public void objectInserted(ObjectInsertedEvent event) {
        System.out.println("objectInserted:" + event);
    }

    @Override
    public void objectUpdated(ObjectUpdatedEvent event) {
        System.out.println("objectUpdated:" + event);
    }

    @Override
    public void objectDeleted(ObjectDeletedEvent event) {
        System.out.println("objectDeleted:" + event);
    }
}
