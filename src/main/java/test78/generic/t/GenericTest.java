package test78.generic.t;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/19/18
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class GenericTest {

    public static void main(String[] args) {
        Generic generic = new Generic<Integer>(1111111);
        System.out.println(generic.getKey());

        Generic generic2 = new Generic<String>("urafool");
        System.out.println(generic2.getKey());

        // 不传入泛型类型实参也是可以的
        Generic generic3 = new Generic("1111");
        Generic generic4 = new Generic(4444);
        Generic generic5 = new Generic(55.55);
        Generic generic6 = new Generic(false);

    }
}
