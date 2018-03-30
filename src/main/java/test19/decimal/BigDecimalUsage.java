package test19.decimal;

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
public class BigDecimalUsage {

    public static void main(String[] args) {



        BigDecimal percent = new BigDecimal("1");
        BigDecimal b2 = new BigDecimal(0.1111111);
        BigDecimal result = percent.subtract(b2);
        System.out.println(b2); //0.11111110000000000430642188575802720151841640472412109375
        System.out.println(result); //0.88888889999999999569357811424197279848158359527587890625

        // 保留两位小数, 第二位小数加一, 不论第三位是否大于5
        System.out.println(b2.setScale(2, BigDecimal.ROUND_UP)); //0.12
        System.out.println(result.setScale(2, BigDecimal.ROUND_UP)); //0.88

        // 保留两位小数, 不四舍五入, 直接丢掉多余小数
        System.out.println(result.setScale(2, BigDecimal.ROUND_DOWN)); //0.88

        // ???
        System.out.println(result.setScale(2, BigDecimal.ROUND_CEILING)); //0.89

        //
        System.out.println(result.setScale(2, BigDecimal.ROUND_FLOOR)); //0.89









    }
}
