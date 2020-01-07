package test84.eventbus;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@SuppressWarnings("all")
public class EventBusConfiguration implements InitializingBean, DisposableBean {

    @Autowired
    private ApplicationContext applicationContext;

    private Map<String, EventAdapter> beans = null;

    @Override
    public void afterPropertiesSet() throws Exception {

        beans = applicationContext.getBeansOfType(EventAdapter.class);
        if (beans != null) {
            for (EventAdapter eventAbstract : beans.values()) {
                EventBusFacade.register(eventAbstract);
            }
        }
    }

    @Override
    public void destroy() throws Exception {
        if (beans != null) {
            for (EventAdapter eventAbstract : beans.values()) {
                EventBusFacade.unregister(eventAbstract);
            }
        }
    }

}
