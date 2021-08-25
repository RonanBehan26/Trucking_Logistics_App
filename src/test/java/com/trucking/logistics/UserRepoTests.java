package com.trucking.logistics;

import com.trucking.logistics.entites.User;
import com.trucking.logistics.services.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserRepoTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		User user = new User("Tom", "Great");
		userService.createUser(user);
		List<User> users = userService.findAll();
		System.out.println(users.get(0).getUserName());
	}

}
