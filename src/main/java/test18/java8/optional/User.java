package test18.java8.optional;

import java.util.List;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/10/18
 * Time: 11:05 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class User {

    public String name;

    public void setName(String name) throws IllegalArgumentException {
        this.name = Optional.ofNullable(name)
                .filter(User::isNameValid)
                .orElseThrow(()->new IllegalArgumentException("invalid param"));

    }

    private static boolean isNameValid(String s) {
        return true;
    }

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
