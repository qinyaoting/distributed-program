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
        // 泛型类
        Box box = new Box();        //Box未指定的支持泛型, 可以往里边放东西
        box.setObj(new Apple());
        Apple ap = (Apple) box.getObj();// 需要强制转换

        Box<Apple> box2 = new Box<Apple>();
        box2.setObj(new Apple());
        Apple ap2 = box2.getObj();  //不需要转换了, 直接拿到了Apple


        Apple ap3 = getInstance(Apple.class);

    }

    // 泛型方法的使用
    // T 是返回类型? Class<T>?
    private static <T> T getInstance(Class<T> cls) throws IllegalAccessException, InstantiationException {
        return cls.newInstance();
    }
}
