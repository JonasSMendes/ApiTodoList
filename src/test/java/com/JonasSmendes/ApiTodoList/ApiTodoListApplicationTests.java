package com.JonasSmendes.ApiTodoList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class ApiTodoListApplicationTests {

	@Test
	void contextLoads() {
	}

}
