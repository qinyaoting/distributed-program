package test32.mock;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 4:03 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    public Employee findByName(String name);
}
