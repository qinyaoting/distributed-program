package test37.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 4/1/18
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Builder
@Data
public class BuilderExample {

    private String name;
    private int age;

    @Singular
    private Set<String> occupations;

}
