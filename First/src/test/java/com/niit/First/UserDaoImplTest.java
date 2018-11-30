/*package com.niit.First;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.UserDao;
import com.niit.daoImpl.UserDaoImpl;
import com.niit.model.User;

import junit.framework.TestCase;

public class UserDaoImplTest extends TestCase 
{
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,UserDaoImpl.class);
	   UserDao userDao=(UserDao)context.getBean("userDao");
	    public void testSaveUser() 
	    {
		User user =new User();
		user.setUid(100);
		user.setName("priya");
		user.setPwd("123");
		user.setMobno("1234567");
		user.setEmailid("priya20@gamil.com");
		user=userDao.addUser(user);
		assertTrue(user.getUid()>0); 
		
	}
	
	    public void testUpdateUser()
	    {
	     User user=userDao.selectUser(102);	 
	     user.setPwd("1234");
	     user.setMobno("12345678");
	     userDao.updateUser(user);
	     System.out.println(user.getMobno());
	     assertTrue(user.getPwd()=="1234");
	     assertTrue(user.getMobno()=="12345678");
	    }
	
	
        public void testGetUser()
        {
        User user1=userDao.selectUser(102);
        User user2=userDao.selectUser(103);
        User user3=userDao.selectUser(15);
        assertNotNull(user1);
        assertNotNull(user2);
        assertNull(user3);
       String expectedmailId="vidhya@gmail.com";
       String actualmailId=user2.getEmailid();
       assertTrue(expectedmailId.equals(actualmailId));
}
	
        public void testDeleteUser()
        {
         userDao.deleteUser(17);  
         assertNull(userDao.selectUser(17));	 
        }
        public void testGetAllUsers()
        {
         List<User> userList=userDao.getUser(); 
         assertNotNull(userList.isEmpty());
        }
	

}
*/