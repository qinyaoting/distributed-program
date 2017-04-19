package test17.builder1;

/**
 * Created by chin on 1/13/17.
 */
public class ConcreteBuilder extends Builder {

    private Product product = new Product();
    @Override
    public void buildPart1() {

    }

    @Override
    public void buildPart2() {

    }

    public Product retrieveProduct() {
        return product;
    }
}
