package test79.functionalinterface;

import java.util.function.Function;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/23/18
 * Time: 11:21 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class UseFoo {

    public String add(String str, Foo foo) {
        return foo.method(str);
    }

    public String add(String str, Function<String,String> fn) {
        return fn.apply(str);//不知道是什么意思
    }
}
