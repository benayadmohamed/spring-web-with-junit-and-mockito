package com;

import com.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

// avec Junit 5 cette methode n'est pas obligatiore
//@RunWith(SpringRunner.class)

//@SpringBootTest on peut pas la melanger avec @DataJpaTest
// pour fair les tete de Jpa il faut faire un base de done embended
// <dependency>
//    <groupId>com.h2database</groupId>
//    <artifactId>h2</artifactId>
//    <scope>test</scope>
//    <version>1.4.194</version>
//</dependency>
@DataJpaTest
//@AutoConfigureTestDatabase
class DataJpaTestApplicationTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
        Employee alex = new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();

        // when
        Employee found = employeeRepository.findByName(alex.getName());

        // then
        assertThat(found.getName())
                .isEqualTo(alex.getName());
    }

}
