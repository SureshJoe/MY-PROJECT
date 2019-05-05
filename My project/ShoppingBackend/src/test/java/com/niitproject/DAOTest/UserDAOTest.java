package com.niitproject.DAOTest;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niitproject.DAO.UserDAO;
import com.niitproject.Sections.User;

public class UserDAOTest {
	static UserDAO userDAO;

	@SuppressWarnings("resource")
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niitproject");
		context.refresh();
		
		userDAO=(UserDAO)context.getBean("userDAO");
	}
    @Ignore
	@Test
	public void addUserTest()
	{
		User user=new User();
		user.setMobileNo("0123456789");
		user.setPassword("Suresh");
		user.setUsername("Suresh");
		user.setRole("ROLE_USER");
		user.setEmail("123@gmail.com");
		assertTrue("Problem in User Insertion",userDAO.addUser(user));
	}
    @Ignore
	@Test
	public void updateUserTest()
	{
		User user=userDAO.getUser(115);
	    user.setUsername("Joe");
	    user.setRole("ROLE_ADMIN");
		assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
    @Ignore
    @Test
	public void listUserTest()
	{
		List<User> listUser=userDAO.getUser();
		assertNotNull("No User",listUser);
		
		for(User user:listUser)
		{
			System.out.print(user.getUsername()+" ");
			System.out.print(user.getEmail()+" ");
			
		}
}
}
