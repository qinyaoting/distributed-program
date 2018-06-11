package test58;

import junit.framework.TestCase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 6/8/18
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class TestLogger extends TestCase {


    @Autowired
    private QLogger logger;



    // 测试, 多线程存储, 到容量75%, 进行保存
    public void multiThreadSaveLog() {
        // pool
        // thread
        logger.save("-------");


    }

    // 测试,定时触发
    public void test1() {
        logger.save("----------");
    }

    // 同时达到边界, 不会冲突.



}
