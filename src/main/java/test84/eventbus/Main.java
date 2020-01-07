package test84.eventbus;

public class Main {

    public static void main(String[] args) {

        String json = "{\"tom\":\"cat\"}";
        String tableName = "test";
        EventBusFacade.execute(new SourceDataStorageEvent(json, tableName));

        //TODO= not working
    }
}
