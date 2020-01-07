package test84.eventbus;

import com.google.common.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBusFacade {

    private static final Logger logger = LoggerFactory.getLogger(EventBusFacade.class);

    private final static EventBus eventBus = new EventBus();

    public static void post(BaseEvent event) {
        execute(event);
    }


    public static void execute(BaseEvent event) {
        if(event == null){
            return ;
        }
        eventBus.post(event);
    }



    public static void register(EventAdapter<? extends BaseEvent> handler) {
        if(handler == null){
            return ;
        }
        eventBus.register(handler);
        logger.info("Registered eventAdapter class: {}", handler.getClass());
    }


    public static void unregister(EventAdapter<? extends BaseEvent> handler) {
        if(handler == null){
            return ;
        }
        eventBus.unregister(handler);
        logger.info("Unregisted eventAdapter class: {}", handler.getClass());
    }

}
