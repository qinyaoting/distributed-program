package test18.java8.list;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/9/18
 * Time: 6:39 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {


    public static void main(String[] args) throws IOException {

        String json = "{'articles':[" +
                "{'title':'springboot','author':'jack','tags':['java','bigdata','web']}," +
                "{'title':'hadoop','author':'jack','tags':['java','bigdata']}," +
                "{'title':'web development','author':'jack','tags':['java','web']}," +
                "{'title':'jvm','author':'jack','tags':['java']}," +

                "{'title':'springmvc','author':'lucy','tags':['java','mvc','web']}," +
                "{'title':'hbase','author':'lucy','tags':['java']}," +
                "{'title':'tomcat','author':'lucy','tags':['java']}," +

                "{'title':'java8','author':'hmm','tags':['java']}," +
                "{'title':'nginx','author':'hmm','tags':['server']}" +
                "]}";


        // 把字符串中的单引号变为双引号

        json = json.replaceAll("\'", "\"");
        System.out.println(json);

        // 把json反序列化为对象
        ObjectMapper mapper = new ObjectMapper();
        BlogShop shop = mapper.readValue(json,BlogShop.class);


        // 书的标签包含java的书
        List<Article> list = shop.getAllArticles();
        list.forEach(System.out::println);
        //list.forEach(item->System.out.println(item));

        // 在集合中查找包含“java”标签的第一篇文章
        Optional<Article> article = shop.getFirstJavaArticle();
        System.out.println("tag contain word of java in first place:" + article);


        // 根据作者来把所有的文章分组。
        Map<String, List<Article>> map =  shop.groupByAuthor();
        map.forEach((k,v) ->System.out.printf("author:%s articles:%s \n", k,v));










    }
}
