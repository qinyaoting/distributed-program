package test78.generic.t;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/19/18
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Generic<T> {

    private T key;
    public Generic(T key) {
        this.key = key;
    }
    public T getKey(){
        return key;
    }
}
