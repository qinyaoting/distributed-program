package test19.decimal;

import com.google.common.primitives.Doubles;
import com.google.common.primitives.Floats;
import javafx.util.converter.DoubleStringConverter;
import org.apache.commons.lang.math.NumberUtils;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/25/18
 * Time: 2:41 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class StringToDouble {

    // improve01 如何把字符串变为double
    public static void main(String[] args) {

        // 第1部分
        String val = "12.34";
        String invalidVal = "1x.34";

        double d1 = Double.parseDouble(val);
        System.out.println(d1);
        //double d11 = Double.parseDouble(invalidVal);      NumberFormatException
        // 用try比较繁琐, 丑陋
        try {
            double d12 = Double.parseDouble(invalidVal);
        } catch (NumberFormatException e){

        }

        double d111 = Double.valueOf(val);
        System.out.println(d111);

        double d2 = new DoubleStringConverter().fromString(val);
        //double d22 = new DoubleStringConverter().fromString(invalidVal);  NumberFormatException: For input string: "1x.34"

        // 第2部分 ,可以传递一个默认值
        // org.apache.commons.lang3.math.NumberUtils
        double b1 = NumberUtils.toDouble(val,0);
        double b12 = NumberUtils.toDouble(invalidVal,0);
        System.out.println("NumberUtils:" + b1);
        System.out.println("NumberUtils:" + b12);

        // 第3部分
        double c11 = Doubles.tryParse(val);
        System.out.println("Doubles:" + c11);

        double c12 = Doubles.stringConverter().convert(val);
        System.out.println("Doubles:" + c12);

    }
}
