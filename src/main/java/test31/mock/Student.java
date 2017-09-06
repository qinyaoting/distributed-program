package test31.mock;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 2:02 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Student {

    private String id;
    private String name;
    private String description;
    private List<Course> courses;

    public Student(String id, String name, String description, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.courses = courses;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return String.format(
                "Student[id=%s, name=%s, description=%s, courses=%s]", id,
                name, description, courses
        );
    }
}
