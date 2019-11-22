package com;

import com.models.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

// avec Junit 5 cette methode n'est pas obligatiore
//@RunWith(SpringRunner.class)
@SpringBootTest
class DataJpaTestWithMockBean {

    @InjectMocks // auto inject helloRepository
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        Employee alex = new Employee("alex");
// va retouner alex quand l'utilisateur lance la methode findByName dans EmployeeServiceImpl
        Mockito.when(employeeRepository.findByName(alex.getName()))
                .thenReturn(alex);
    }

    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
       /* Employee alex = new Employee("alex");
        given(employeeRepository.findByName(alex.getName())).willReturn(alex);
*/
        String name = "alex";
        Employee found = employeeService.getEmployeeByName(name);

        assertThat(found.getName())
                .isEqualTo(name);
    }

}
