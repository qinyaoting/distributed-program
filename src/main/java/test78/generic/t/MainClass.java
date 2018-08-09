package test78.generic.t;

import com.google.common.collect.Lists;

import java.util.List;

import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 7/19/18
 * Time: 11:16 AM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) {

        List<String> str = Lists.newArrayList(null, "", " ", "666");
        str.forEach(item->{
            System.out.println(defaultIfBlank(item,"default"));
        });
    }

    // 返回参数要求是CharSequence的子类
    public static <T extends CharSequence> T defaultIfBlank(T str, T defaultStr) {
        return isBlank(str)?defaultStr:str;
    }
}
