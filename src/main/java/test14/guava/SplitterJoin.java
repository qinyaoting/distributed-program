package test14.guava;


import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by chin on 11/28/16.
 *
 * http://www.cnblogs.com/Jack47/p/Guava-Common-Utilities.html
 *
 *
 */
public class SplitterJoin {

    public static void main(String[] args) {
        ///Map<String, Map<Long, List<String>>> map = new HashMap<String, Map<Long,List<String>>>();

        //Map<String, Map<Long,List<String>>> map = Maps.newHashMap();


        ImmutableList<String> of = ImmutableList.of("a", "b", "c", "d");
        ImmutableMap<String,String> map = ImmutableMap.of("key1", "value1", "key2", "value2");



        int compare = Ints.compare(-2,2);
        System.out.println(compare);

        //assertEquals("89983", CharMatcher.DIGIT.retainFrom("some text 89983 and more"));
        //assertEquals("some text  and more", CharMatcher.DIGIT.removeFrom("some text 89983 and more"));

        int[] numbers = { 1, 2, 3, 4, 5 };

        String numberAsString = Joiner.on(";").join(Ints.asList(numbers));
        System.out.println(numberAsString);

        String str2 = Ints.join(";",numbers);


        Iterable split = Splitter.on(",").split(numberAsString);




        String testString = "foo , what,,,more,";
        Iterable<String> split2 = Splitter.on(",").omitEmptyStrings().trimResults().split(testString);
        System.out.println();



        // 分割字符串 100-200 0-200 -200 100- -

        String[] str11 = StringUtils.split("100-2000", "-");
        String[] str12 = StringUtils.split("0-2000", "-");
        String[] str13 = StringUtils.split("100-", "-");
        String[] str14 = StringUtils.split("-", "-");

        System.out.println(str14.length);


        // url参数自动变为map
        String ss = "amount=233&sourceUserId=2&targetUserId=9999&timestamp=1577954264122";
        final Map<String, String> params = Splitter.on("&").withKeyValueSeparator("=").split(ss);

    }
}
