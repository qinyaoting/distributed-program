package test32;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import test32.mock.Employee;
import test32.mock.EmployeeRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();
        Employee found = employeeRepository.findByName("alex");
        assertThat(found.getName()).isEqualTo(alex.getName());
    }



}
