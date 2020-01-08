package test82.inttool;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/30/18
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {


        // 把字符串变为整数，可以传递默认值，不抛出异常
        //first
        int withDefault = NumberUtils.toInt("10x",0);
        System.out.println(withDefault);


        boolean bb = NumberUtils.isDigits("10x");
        boolean bbb = NumberUtils.isDigits("100");
        System.out.println(bbb);

        //second

        //Third

    }
}
