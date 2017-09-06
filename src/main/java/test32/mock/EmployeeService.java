package test32.mock;

import java.util.List;

/**
 * Created by chin on 9/5/17.
 */
public interface EmployeeService {


    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployees();
}
