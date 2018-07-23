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
public class MainClass {

    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();
        Foo foo = parameter->parameter+" from lambda";
        String result = useFoo.add("Msg ", foo);

        // 没有必要创建Foo, java已经为我们提供了Function
        Function<String,String> fn =
                parameter->parameter+" from lambda";
        String result2 = useFoo.add("Msg ", fn);
        System.out.println(result2);

    }
}
