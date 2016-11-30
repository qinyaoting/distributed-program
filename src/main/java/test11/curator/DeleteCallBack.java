package test11.curator;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.CuratorEvent;

/**
 * Created by chin on 11/30/16.
 */
public class DeleteCallBack implements org.apache.curator.framework.api.BackgroundCallback {
    @Override
    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
        System.out.println("111");
    }
}
