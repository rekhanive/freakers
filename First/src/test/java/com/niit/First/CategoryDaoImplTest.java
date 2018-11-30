package com.niit.First;



import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDao;
import com.niit.daoImpl.CategoryDaoImpl;
import com.niit.model.Category;
import com.niit.model.Product;

import junit.framework.TestCase;

public class CategoryDaoImplTest extends TestCase
{
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,CategoryDaoImpl.class);
	CategoryDao categoryDao=(CategoryDao)context.getBean("categoryDao");
	    public void testSaveCategory() 
	    {
		Category category =new Category();
		category.setCategoryId(109);
		category.setCategoryname(" watch");
		category.setCategorydesc("use");
		category=categoryDao.addCategory(category);
		assertTrue(category.getCategoryId()>0); 
		
	}
	
        public void testUpdateCategory() 
        {
		Category category=categoryDao.selectCategory(100);
		category.setCategoryname("ipod");
		category.setCategorydesc("player");
		categoryDao.updateCategory(category);
		assertTrue(category.getCategoryname().equals("ipod"));
		assertTrue(category.getCategorydesc().equals("player"));
	}
        
        public void testGetCategory()
        {
    	  Category category1=categoryDao.selectCategory(104);
    	  Category category2=categoryDao.selectCategory(106);
    	  Category category3=categoryDao.selectCategory(1);
    	  assertNotNull(category1);
    	  assertNotNull(category2);
    	  assertNull(category3);
    	  String expectedname="Digital watch";
    	  String actualname=category1.getCategoryname();
    	  assertTrue(expectedname.equals(actualname));
       }
        
        public void testDeleteCategory()
        {
     	categoryDao.deleteCategory(103);  
     	assertNull(categoryDao.selectCategory(103));
        }
        public void testGetAllCategory()
        {
         List<Category> categoryList=categoryDao.getAllCategory(); 
         assertNotNull(categoryList.isEmpty());
        }
	
	
}
