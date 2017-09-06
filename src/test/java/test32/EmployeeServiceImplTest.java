package test32;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import test32.mock.Employee;
import test32.mock.EmployeeRepository;
import test32.mock.EmployeeService;
import test32.mock.EmployeeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 4:12 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService () {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setup() {
        Employee alex = new Employee("alex");
        Mockito.when(employeeRepository.findByName(alex.getName()))
                .thenReturn(alex);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "alex";
        Employee found = employeeRepository.findByName(name);
        assertThat(found.getName()).isEqualTo(name);
    }


}
