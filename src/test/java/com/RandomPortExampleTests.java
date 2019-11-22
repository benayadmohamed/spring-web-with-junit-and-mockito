package com;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

// avec Junit 5 cette methode n'est pas obligatiore
//@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomPortExampleTests {


    @Test
    public void exampleTest() {
        assertThat("Hello World").isEqualTo("Hello World");
    }

}
