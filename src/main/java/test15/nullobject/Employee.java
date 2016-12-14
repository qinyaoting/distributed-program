package test15.nullobject;

import java.util.Date;

/**
 * Created by chin on 12/14/16.
 */
public interface Employee {


    public boolean isTimeToPay(Date date);
    public void pay();

    // 在接口中创建了一个匿名内部类
    public static final Employee NULL = new Employee() {
        @Override
        public boolean isTimeToPay(Date date) {
            return false;
        }

        @Override
        public void pay() {

        }
    };

}
