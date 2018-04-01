package test37.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 4/1/18
 * Time: 8:38 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {


    private long id;
    private String name;
    private double income;


}
