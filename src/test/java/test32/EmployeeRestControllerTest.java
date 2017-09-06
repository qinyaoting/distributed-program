package test32;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import test32.mock.Employee;
import test32.mock.EmployeeRestController;
import test32.mock.EmployeeService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 9/5/17
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = EmployeeRestController.class, secure = false)
public class EmployeeRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private EmployeeService service;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

        Employee alex = new Employee("alex");
        List<Employee> allEmployees = Arrays.asList(alex);
        given(service.getAllEmployees()).willReturn(allEmployees);

        mvc.perform(MockMvcRequestBuilders.get("/api/employees")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }
}
