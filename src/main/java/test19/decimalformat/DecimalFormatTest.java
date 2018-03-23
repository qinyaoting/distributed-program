package test19.decimalformat;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 3/23/18
 * Time: 9:22 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class DecimalFormatTest {

    public static void main(String[] args) {



        //1. 保留两位小数
        //
        //System.out.println(123.000);    // 结果默认带一位小数123.0
        //System.out.println(123.5600);    // 结果123.56

        double f = 111231.5585;
        double f2 = 111231.5000;
        Object f3 = null;
        String f4 = "111231.5000";
        String f5 = "1xxx1231.5000";


        // 方法1
        BigDecimal bd1 = new BigDecimal(f);
        double d1 = bd1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("1 : " + d1);     // 111231.56

        // 会舍弃末尾的0
        BigDecimal bd2 = new BigDecimal(f2);
        double d2 = bd2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("1 : " + d2);     // 111231.5

        //可以传字符串
        BigDecimal bd4 = new BigDecimal(f4);
        double d4 = bd4.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("1 : " + d4);     // 111231.5


        /* 包含字母的字符串不行
        BigDecimal bd5 = new BigDecimal(f5);
        double d5 = bd5.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("1 : " + d5);     */


        // 方法2
        DecimalFormat df1 = new DecimalFormat("#.00");
        System.out.println(df1.format(123));      // 123.00
        System.out.println(df1.format(123.456f));      // 123.46
        System.out.println(df1.format(f));      // 111231.56
        System.out.println(df1.format(f2));     // 111231.50


        // 方法3
        System.out.println("3 : " + String.format("%.2f", f));   // 111231.56
        System.out.println("3 : " + String.format("%.2f", f2));  // 111231.50
        System.out.println("3 : " + String.format("%.2f", f3));  // nu
        //---System.out.println("3 : " + String.format("%.2f", f4));
        //---System.out.println("3 : " + String.format("%.2f", f5));

        // 方法4, 用采用逗号分割超过3位的数字
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println("4:" + nf.format(f));        // 111,231.56
        System.out.println("4:" + nf.format(f2));       // 111,231.5
        //---System.out.println("4:" + nf.format(f4));       // 111,231.5
        //---System.out.println("4:" + nf.format(f5));       // 111,231.5


        //3. 把带有小数的数字转换为包含两位小数的字符串
        // 123.45-> 123.45
        // 123.40 -> 123.4


        DecimalFormat df = new DecimalFormat("###.##");

        System.out.println(df.format(123.45));
        System.out.println(df.format(123.40));









    }
}
