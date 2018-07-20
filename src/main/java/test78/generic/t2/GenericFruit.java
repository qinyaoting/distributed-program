package test78.generic.t2;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/20/18
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class GenericFruit {

    static class Fruit{
        @Override
        public String toString() {
            return "fruit";
        }
    }

    static class Apple extends Fruit{
        @Override
        public String toString() {
            return "apple";
        }
    }

    static class Person{
        @Override
        public String toString() {
            return "person";
        }
    }

    static class GenerateTest<T> {
        public void show1(T t) {
            System.out.println(t.toString());
        }

        public <E> void show2(E e) {
            System.out.println(e.toString());
        }

        public <T> void show3(T t) {
            System.out.println(t.toString());
        }
    }

    public static void main(String[] args) {
        Apple apple = new Apple();
        Person person = new Person();

        GenerateTest<Fruit> generateTest = new GenerateTest<Fruit>();
        generateTest.show1(apple);
        // 编译失败
        // generateTest.show1(person);

        generateTest.show3(apple);
        generateTest.show3(person);

        generateTest.show2(apple);
        generateTest.show2(person);

        printMsg("111", 222, "aaa", 55.55);
    }

    public static  <T> void printMsg(T... args) {
        for (T t: args) {
            System.out.println(t.toString());
        }
    }
}
