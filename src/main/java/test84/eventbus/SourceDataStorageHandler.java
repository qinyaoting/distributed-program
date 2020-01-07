package test84.eventbus;

import org.springframework.stereotype.Component;

@Component
public class SourceDataStorageHandler extends EventAdapter<SourceDataStorageEvent> {

    @Override
    public boolean process(SourceDataStorageEvent event) {
        System.out.println(String.format("收到消息 %s %s ",event.getDataJson(),event.getTargetDbTable()));
        return true;
    }



}