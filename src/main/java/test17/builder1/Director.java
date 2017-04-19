package test17.builder1;

/**
 * Created by chin on 1/13/17.
 */
public class Director {

    private Builder builder;

    public void construct() {
        builder = new ConcreteBuilder();
        builder.buildPart1();
        builder.buildPart2();
        builder.retrieveProduct();
        // continue with other code
    }


}
