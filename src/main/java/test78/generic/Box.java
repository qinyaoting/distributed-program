package test78.generic;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/14/18
 * Time: 5:40 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Box<T> {   //泛型类, 表示set进来的obj,和get出去的obj必须类型一样, 而且get的时候, 不用强转了

    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}
