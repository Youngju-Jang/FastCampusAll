package com.example.hello;

import com.example.hello.dto.ch5_User2;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloApplicationTests {

	@Test
	void contextLoads() throws JsonProcessingException {
		System.out.println("-------------------------");

		var objectMapper = new ObjectMapper();

		// object -> text
		// objectMapper >> getMethod 활용함
		var user = new ch5_User2("steve", 10, "010-1234-1234");
		var text = objectMapper.writeValueAsString(user);
		System.out.println(text); // {"name":"steve","age":10}

		// text -> object
		// objectMapper >> Default 생성자가 필요함
		var objectUser = objectMapper.readValue(text, ch5_User2.class);
		System.out.println(objectUser);

	}

}
