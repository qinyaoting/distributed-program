package test18.java8.optional;

import com.sun.nio.sctp.IllegalReceiveException;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Collections;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/10/18
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass3 {

    private static final User UNKNOWN_USER = new User();

    public static void main(String[] args) {

        // 可以用of 和ofNullable来创建对象
        //Optional<User> user = Optional.of(new User());
        // 传空会抛异常NullPointerException
        //Optional<User> user = Optional.of(null);

        //传空给ofNullable不会有异常
        Optional<User> user = Optional.ofNullable(new User());
        //Optional<User> user = Optional.ofNullable(null);
        if (user.isPresent()) {
            System.out.println(user.get());
        }
        //1. 代替上边if判断
        user.ifPresent(System.out::println);

        //2. 获取user关联的order
        // 错误用法
        if (user.isPresent()) {
            user.get().getOrders();
        } else {
            Collections.emptyList();
        }
        // 正确用法用map
        user.map(u->u.getOrders()).orElse(Collections.emptyList());

        //3. map可以无限级联
        user.map(u->u.name)
                .map(name->name.toUpperCase())
                .orElse(null);
        //错误的用法
        User user1 = new User();
        if (user1!=null) {
            String name = user1.name;
            if (name!=null) {
                name.toUpperCase();
            }else {
                // return null;
            }
        } else {
            // return null;
        }


    }

    public static User getUser(Optional<User> user) {

        // 错误
        // return user.isPresent() ? user.get() : null;

        //正确
        //4. 存在即返回, 无则提供默认值
        // return user.orElse(null);
        // return user.orElse(UNKNOWN_USER);

        // 存在即返回, 无则由函数来产生
        //而不要 return user.isPresent() ? user: fetchAUserFromDatabase();
        return user.orElseGet(()->fetchUserFromDatabase());
    }

    private static User fetchUserFromDatabase() {

        return null;
    }


}
