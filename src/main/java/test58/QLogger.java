package test58;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 6/8/18
 * Time: 5:01 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class QLogger {

    private List<String> container = Lists.newArrayList();

    // 1. 多个线程可以同时写 写多个批次
    public void save(String record) {
        container.add(record);
    }

    // 容量超过75%, 进行保存???

    // 超过5min, 进行保存

    // bean 销毁前, 进行保存

    // 得有开关, 防止同时到达边界
    private void scheduleFlush() {

    }

    private void flush() {

    }
}
