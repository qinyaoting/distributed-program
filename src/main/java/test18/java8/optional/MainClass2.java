package test18.java8.optional;

import com.sun.nio.sctp.IllegalReceiveException;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/10/18
 * Time: 11:28 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass2 {

    public static void main(String[] args) {



    }

    // 嵌套判断对象是否是空,非常丑陋的写法
    public static String getCompetitionName(Competition comp) throws IllegalArgumentException {
        if (comp != null) {
            CompResult result = comp.getResult();
            if (result != null) {
                User u = result.getUser();
                if (u != null) {
                    return u.name;
                }
            }
        }
        throw new IllegalArgumentException("the value of param comp isn't avalid");
    }

    // 漂亮的写法
    public static String getChampionName(Competition comp) throws IllegalReceiveException {
        return Optional.ofNullable(comp)
                .map(c->c.getResult())
                .map(r->r.getUser())
                .map(u->u.name)
                .orElseThrow(()->new IllegalArgumentException("the value of param comp isn't avalid"));
    }
}
