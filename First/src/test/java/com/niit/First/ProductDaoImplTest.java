package com.niit.First;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.ProductDao;
import com.niit.daoImpl.ProductDaoImpl;
import com.niit.model.Product;

import junit.framework.TestCase;

public class ProductDaoImplTest extends TestCase 
{
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,ProductDaoImpl.class);
	   ProductDao productDao=(ProductDao)context.getBean("productDao");
	public void testSaveProduct() {
		Product product =new Product();
		product.setPrice(1000.00);
		product.setQuantity(1);
		product.setProductname("Water Bottle");
		product.setProductdesc("Blue color - l litre");
		product=productDao.addProduct(product);
		assertTrue(product.getId()>0); 
		
	}

	public void testGetProduct() {
		  Product product1=productDao.selectProduct(1);
		   Product product2=productDao.selectProduct(2);
		   Product product3=productDao.selectProduct(11);
		  
		   assertNotNull(product1);
		   assertNotNull(product2);
		   assertNull(product3);
		   
		   
		   double expectedPrice=40000.0;
		   double actualPrice=product2.getPrice();
		   assertTrue(expectedPrice==actualPrice);
	}

	public void testUpdateProduct() {
		
		Product product=productDao.selectProduct(1);
		product.setPrice(4000.0);
		product.setQuantity(25);
		productDao.updateProduct(product);
		assertTrue(product.getPrice()==4000);
		assertTrue(product.getQuantity()==25);
	}
	
	public void testDeleteProduct()
	{
	  productDao.deleteProduct(3);
	  assertNull(productDao.selectProduct(3));
	}
	
	public void testGetAllProduct()
    {
		List<Product>product=productDao.getAllProduct();
		assertFalse(product.isEmpty());
	}
	
	
	
}
