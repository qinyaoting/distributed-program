package test18.java8.list;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by chin on 4/19/17.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {

    public String title;          //文章标题
    public String author;         //作者
    public List<String> tags;     //标签

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
