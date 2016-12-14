package test15.nullobject;

import java.util.Date;

/**
 * Created by chin on 12/14/16.
 */
public class TestEmployee {

    public static void main(String[] args) {
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(new Date()))
            e.pay();

        if (e!=null && e.isTimeToPay(new Date()))
            e.pay();

        // 就不用判断e是否是null了

    }
}
