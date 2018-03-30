package test18.stream;

import java.util.List;

/**
 * Created by chin on 4/19/17.
 */
public class Article {

    public final String title;
    public final String author;
    public final List<String> tags;

    public Article(String title, String author, List<String> tags) {
        this.title = title;
        this.author = author;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }
}
