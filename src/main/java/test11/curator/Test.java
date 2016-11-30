package test11.curator;

/**
 * Created by chin on 11/30/16.
 */
public class Test {


    public static void main(String[] args) throws Exception {
        CuratorUtils cu = new CuratorUtils();
        //cu.createNode("/node/ex1", "erhu".getBytes());
        //cu.delNode("/test");

        //cu.zkclient.setData().forPath("/aa", "love is not".getBytes());
        cu.addChildWatcher("/node");

        try{
            Thread.sleep(20000000);
        }catch(Exception e){};
    }





}
