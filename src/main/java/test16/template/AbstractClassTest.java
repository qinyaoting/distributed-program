package test16.template;

/**
 * Created by chin on 1/6/17.
 */
public  class AbstractClassTest {

    public static void main(String[] args) {
        AbstractClass c;
        c= new ConcreteClassA();
        c.templateMethod();

        c=new ConcreteClassB();
        c.templateMethod();
    }
}
