package test78.generic;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/14/18
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Box box = new Box();
        box.setObj(new Apple());
        Apple ap = (Apple) box.getObj();// 需要强制转换

        Box<Apple> box2 = new Box<Apple>();
        box2.setObj(new Apple());
        Apple ap2 = box2.getObj();  //不需要转换了


        Apple ap3 = getInstanec(Apple.class);

    }

    private static <T> T getInstanec(Class<T> cls) throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }
}
