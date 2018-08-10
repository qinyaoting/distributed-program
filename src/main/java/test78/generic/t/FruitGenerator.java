package test78.generic.t;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/19/18
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class FruitGenerator<T> implements Generator<T> {   //实现了接口, 可以不指定具体的类型, 继续用T

    @Override
    public T next() {
        return null;
    }   //T跟返回值是绑定在一起的
}
