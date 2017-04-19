package test18.java8;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chin on 4/19/17.
 */


public class TestStream {


    @Test
    public void test() {

    }

    private List<Article> articles = Lists.newArrayList();

    //在集合中查找包含“Java”标签的第一篇文章
    public Article getFirstJavaArticle1() {
        for (Article article : articles) {
            if (article.getTags().contains("java"))
                return article;
        }
        return null;
    }

    public Optional<Article> getFirstJavaArticle() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .findFirst();
    }

    //获取所有匹配的元素而不是仅获取第一个。
    public List<Article> getAllJavaArticles1() {
        List<Article> result = new ArrayList<>();
        for (Article article : articles) {
            if (article.getTags().contains("Java")) {
                result.add(article);
            }
        }
        return result;
    }

    public List<Article> getAllArticles() {
        return articles.stream()
                .filter(article -> article.getTags().contains("Java"))
                .collect(Collectors.toList());
    }

    //根据作者来把所有的文章分组。
    public Map<String, List<Article>> groupByAuthor1() {

        Map<String, List<Article>> result = new HashMap<>();

        for (Article article : articles) {
            if (result.containsKey(article.getAuthor())) {
                result.get(article.getAuthor()).add(article);
            } else {
                ArrayList<Article> articles = new ArrayList<>();
                articles.add(article);
                result.put(article.getAuthor(), articles);
            }
        }

        return result;
    }

    public Map<String, List<Article>> groupByAuthor() {
        return articles.stream()
                .collect(Collectors.groupingBy(Article::getAuthor));
    }

    //查找集合中所有不同的标签。
    public Set<String> getDistinctTags1() {

        Set<String> result = new HashSet<>();

        for (Article article : articles) {
            result.addAll(article.getTags());
        }

        return result;
    }

    public Set<String> getDistinctTags() {
        return articles.stream()
                .flatMap(article -> article.getTags().stream())
                .collect(Collectors.toSet());
    }

}
