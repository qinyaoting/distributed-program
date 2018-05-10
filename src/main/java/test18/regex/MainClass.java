package test18.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/10/18
 * Time: 3:00 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {

        //1. 要进行搜索的字符串
        String s = "abc-123!abc-456!";
        String reges = "[\\d]+(!)";     //匹配几个数字后边跟一个叹号
        Pattern p = Pattern.compile(reges);
        Matcher m  = p.matcher(s);

        //???System.out.println(m.matches());

        while (m.find()) {
            String ss = m.group();
            String s0 = m.group(0);
            String s1 = m.group(1);
            //-String s2 = m.group(2);
            System.out.printf("%s \r\n", ss);

        }

        //2. 方法需要每次创建对象吗? 需要根据字符串构造Pattern, 所以每次需要new对象
        String isMatch = RegexUtils.match(s, reges);
        System.out.println(isMatch);




    }

}
