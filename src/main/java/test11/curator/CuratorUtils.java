package test11.curator;

/**
 * Created by chin on 11/30/16.
 */
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.framework.recipes.cache.PathChildrenCache.StartMode;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;

/**
 * @see 测试curator框架例子
 * @Author:xuehan
 * @Date:2016年5月14日下午8:44:49
 *
 * http://blueyan.iteye.com/blog/2298276
 */
public class CuratorUtils {

    public String connectString = "master:2181,slave1:2181,slave2:2181";
    CuratorFramework  zkclient = null ;
    public CuratorUtils(){
        /**
         * connectString连接字符串中间用分号隔开,sessionTimeoutMs session过期时间,connectionTimeoutMs连接超时时间,retryPolicyc连接重试策略
         */
        //CuratorFrameworkFactory.newClient(connectString, sessionTimeoutMs, connectionTimeoutMs, retryPolicy)
        // fluent风格aip
        //    CuratorFrameworkFactory.builder().sessionTimeoutMs(5000).connectString(connectString).namespace("/test").build();
        // 重连策略,没1一秒重试一次,最大重试次数3次
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        zkclient = CuratorFrameworkFactory.builder().connectString(connectString).sessionTimeoutMs(5000).retryPolicy(retryPolicy).namespace("xcompany").build();
        zkclient.start();
    }
    /**
     * 递归创建节点
     * @param path
     * @param data
     * @throws Exception
     */
    public void createNode(String path, byte[] data) throws Exception{
        zkclient.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).withACL(Ids.OPEN_ACL_UNSAFE).forPath(path, data);
    }
    /**
     * 递归删除节点
     * @param path
     * @throws Exception
     */
    public void delNode(String path) throws Exception{
        zkclient.delete().guaranteed().deletingChildrenIfNeeded().forPath(path);
    }   public void zkClose(){
        zkclient.close();
    }
    public void delNodeCallBack(String path) throws Exception{
        zkclient.delete().guaranteed().deletingChildrenIfNeeded().inBackground(new DeleteCallBack()).forPath(path);
    }
    public void dataChanges(String path) throws Exception{
        final NodeCache  dataWatch =  new NodeCache(zkclient, path);
        dataWatch.start(true);
        dataWatch.getListenable().addListener(new NodeCacheListener(){

            public void nodeChanged() throws Exception {
                System.out.println("path==>" + dataWatch.getCurrentData().getPath() + "==data==>" + new String(dataWatch.getCurrentData().getData()));
            }

        });
        zkclient.delete().guaranteed().deletingChildrenIfNeeded().inBackground(new DeleteCallBack()).forPath(path);
    }
    public void addChildWatcher(String path) throws Exception{
        final PathChildrenCache pc = new PathChildrenCache(zkclient, path, true);
        pc.start(StartMode.POST_INITIALIZED_EVENT);
        System.out.println("节点个数===>" + pc.getCurrentData().size());
        pc.getListenable().addListener(new  PathChildrenCacheListener() {

            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                System.out.println("事件监听到"  + event.getData().getPath());
                if(event.getType().equals(PathChildrenCacheEvent.Type.INITIALIZED)){
                    System.out.println("客户端初始化节点完成"  + event.getData().getPath());
                }else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)){
                    System.out.println("添加节点完成"  + event.getData().getPath());
                }else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)){
                    System.out.println("删除节点完成"  + event.getData().getPath());
                }else if(event.getType().equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
                    System.out.println("修改节点完成"  + event.getData().getPath());
                }
            }
        });

    }

    public static void main(String[] args) throws Exception{
        CuratorUtils cu = new CuratorUtils();
        cu.createNode("/node/ex5", "erhu".getBytes());
        //cu.delNode("/test");

        //cu.zkclient.setData().forPath("/aa", "love is not".getBytes());
        cu.addChildWatcher("/node");




        for (int i = 1; i < 5; i++) {
            try{
                Thread.sleep(8000);
            }catch(Exception e){};
            cu.delNode("/node/ex"+i);
        }





        try{
            Thread.sleep(20000000);
        }catch(Exception e){};
    }
}
