package test55.xpath;

import com.google.common.collect.Lists;
import org.htmlcleaner.CleanerProperties;
import org.htmlcleaner.DomSerializer;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 5/15/18
 * Time: 4:51 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class JsoupHelper {


    public static Optional fetchNode(String url, String xpath) throws ParserConfigurationException, XPathExpressionException {
        String html = null;
        try {
            Connection conn = Jsoup.connect(url);
            html = conn.get().body().html();
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
        HtmlCleaner hc = new HtmlCleaner();
        TagNode tn = hc.clean(html);
        Document dom = new DomSerializer(new CleanerProperties()).createDOM(tn);
        XPath tool = XPathFactory.newInstance().newXPath();
        return Optional.ofNullable(
                tool.evaluate(xpath, dom, XPathConstants.NODE));




    }

    public static List<String> fetchAttr(String url, String xpath, String attr) throws XPathExpressionException, ParserConfigurationException {
        Optional result = fetchNode(url,xpath);

        // 判断类型
        // result.filter(src->src instanceof NodeList)
        /*return result.filter(NodeList.class::isInstance)
                .flatMap(NodeList::)
                .map(nl->((NodeList)nl).item())
                .collect(Collectors.toList());*/
        return null;
        //TODO result是NodeList,判断NodeList类型,
        // 再便利NodeList->Node, 从Node中取出
        // node.getAttributes().getNamedItem(attr).getTextContent()
    }





}
