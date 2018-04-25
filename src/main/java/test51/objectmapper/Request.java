package test51.objectmapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 4/25/18
 * Time: 5:44 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Request {
    private Car car;
    private Date datePurchased;
}
