package test55.xpath;

import java.util.Optional;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/15/18
 * Time: 4:58 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class MainClass {

    public static void main(String[] args) throws Exception {
        Optional nodes = JsoupHelper.fetchNode(
                "http://www.jianshu.com/u/bf7b9c013c55",
                "//ul[@class='note-list']/li//a[@class='title']");
        System.out.println(nodes);
    }
}
