package test57.messageformat;

import java.text.MessageFormat;
import java.text.ParsePosition;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/18/18
 * Time: 10:13 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class ObjectsFromStringExample {

    public static void main(String[] args) {
        // 字符串模板构造MessageFormat
        MessageFormat mf = new MessageFormat("String:{0}\nInteger:{1}\nDouble:[2]");
        Object[] objArray = {"This is a string", new Integer(56), new Double(12.34)};
        // 把要插入到模板的值传进去
        String message = mf.format(objArray);
        System.out.println("The message:\n"+message);
        Object[] obj = mf.parse(message, new ParsePosition(0));
        System.out.println("\n\nObjects parsed:");
        for (Object o: obj) {
            System.out.println(o+" of"+o.getClass().toString());
        }
    }
}
