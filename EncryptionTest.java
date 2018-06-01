import static org.junit.Assert.*;

import org.junit.Test;

import businessLayer.service.UserService;

public class EncryptionTest {

	@Test
	public void test() {
		UserService us = new UserService();
		String password = "parola";
		String test = us.encryptPassword(password);
		
		assertEquals(test, us.encryptPassword("parola"));
	}

}
