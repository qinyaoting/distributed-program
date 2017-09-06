package test32.mock;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Entity
@Table(name = "person")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 3, max = 20)
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
