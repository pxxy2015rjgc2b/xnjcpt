package util;

import javax.annotation.Resource;

import org.junit.Test;

import com.xnjcpt.service.user.UserManagerService;

public class UserTest {

	@Resource
	private UserManagerService userManagerService;
	
	@Test
	public void deleteUser(){
		System.out.println();
	}
}
