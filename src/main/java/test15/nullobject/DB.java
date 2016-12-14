package test15.nullobject;

/**
 * Created by chin on 12/14/16.
 */
public class DB {

    public static Employee getEmployee(String name) {

        // 数据库中查找,如果没找到就返回一个NUll grt

        return Employee.NULL;
    }
}
