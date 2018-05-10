package test18.java8.optional;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/10/18
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass1 {

    public static void main(String[] args) {
        //
    }


    //常用的判断空对象的示例
    public static String getName(User u) {
        if (u == null)
            return "Unknown";
        return u.name;
    }

    //使用Optional, 改造改方法, (错误示例), 不要这么做
    public static String getNameWithWrongUsage(User u) {
        Optional<User> user = Optional.ofNullable(u);
        if (user.isPresent())
            return "Unknown";
        return user.get().name;
    }

    // 正确方法 如果对象不为空返回name, 否则返回unknown
    public static String getNameWithRightUsage(User u) {
        return Optional.ofNullable(u)
                .map(user->user.name)
                .orElse("Unknown");
    }
}
