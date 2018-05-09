package test18.java8.list;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.List;

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

        List<Article> articles = Lists.newArrayList();

        String json = "{\"articles\":[" +
                "{\"title\":\"springboot\",\"author\":\"jack\",\"tags\":[\"java\",\"bigdata\",\"web\"]}," +
                "{\"title\":\"hadoop\",\"author\":\"jack\",\"tags\":[\"java\",\"bigdata\"]}," +
                "{\"title\":\"web development\",\"author\":\"jack\",\"tags\":[\"java\",\"web\"]}," +
                "{\"title\":\"jvm\",\"author\":\"jack\",\"tags\":[\"java\"]}," +

                "{\"title\":\"springmvc\",\"author\":\"lucy\",\"tags\":[\"java\",\"mvc\",\"web\"]}," +
                "{\"title\":\"hbase\",\"author\":\"lucy\",\"tags\":[\"java\"]}," +
                "{\"title\":\"tomcat\",\"author\":\"lucy\",\"tags\":[\"java\"]}," +

                "{\"title\":\"java8\",\"author\":\"hmm\",\"tags\":[\"java\"]}," +
                "{\"title\":\"nginx\",\"author\":\"hmm\",\"tags\":[\"server\"]}" +
                "]}";

       

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        TestStream test = mapper.readValue(json,TestStream.class);

        System.out.println(test);













    }
}
