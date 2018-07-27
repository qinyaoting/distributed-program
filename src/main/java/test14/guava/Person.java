package test14.guava;

import com.google.common.base.Objects;

/**
 * Created by chin on 11/28/16.
 */
public class Person {

    public int id;
    public String name;
    public double salary;

    public Person(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Person) {
            return this.id == ((Person)obj).id;
        }
        return false;
    }

    public Person() {
    }

    @Override
    public String toString() {
        /*return Objects.toStringHelper(this)
                .add("id", id)
                .add("name", name)
                .add("salary", salary)
                .toString();*/
        return "";

    }
}
