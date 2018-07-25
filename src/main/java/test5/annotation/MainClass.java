package test5.annotation;

import javafx.util.converter.DoubleStringConverter;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.stream.DoubleStream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/6/18
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) throws ClassNotFoundException {
        // 获得Person中的mirror

        Class cls = Person.class;



        for (Field f : cls.getDeclaredFields()) {
            System.out.println(f.getName());
            System.out.println(f.getGenericType());
            System.out.println(f.getGenericType().getTypeName());
            Type type = f.getGenericType();


            /*if (type instanceof Class) {
                Class cl2 = Class.forName(type.getTypeName());
            }*/

            //System.out.println(f.getClass());
            System.out.println("-----------");
        }
    }
}
