package test18.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/10/18
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class RegexUtils {


    public static String match(String content, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m  = p.matcher(content);
        if (m.find()) {
            return m.group();
        }
        return "";
    }

    public static String match2(String content, String reg) {
        Pattern p = Pattern.compile(reg);
        Matcher m  = p.matcher(content);
        if (m.find()) {
            return m.group();
        }
        return "";
    }

}
