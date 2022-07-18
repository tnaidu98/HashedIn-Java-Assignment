package com.hashkart.user;

import com.hashkart.user.common.LoginUser;
import com.hashkart.user.entities.User;
import com.hashkart.user.repositories.UserRepository;
import com.hashkart.user.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest
class UserApplicationTests {

	@Autowired
	private UserService userService;
	@MockBean
	private UserRepository userRepository;

	@Test
	public void saveTest() {
		User newUser = new User(1,"abc","1234");
		when(userRepository.save(newUser)).thenReturn(newUser);
		assertEquals("User Added Successfully",userService.saveUser(new LoginUser("abc","1234")));
	}



}
