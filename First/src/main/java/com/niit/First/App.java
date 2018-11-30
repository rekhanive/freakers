package com.niit.First;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;


public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(DBConfig.class);
   	 	UserDao userDao= (UserDao) context.getBean("userDao");
   	 	/*User user=new User();
   	 	user.setUid(104);
   	 	user.setName("vigneshwari");
   	 	user.setPwd("234");
   	 	user.setMobno("123456789");
   	 	user.setEmailid("vdhya@gmail.com");
   	 	userDao.addUser(user);
   	 	//userDao.updateUser(user);
   	 	//userDao.deleteUser(user);
   	 	List<User> userList=userDao.getUser();
   	 	for(User userobj:userList)
   	 	{
   	 		System.out.println(userobj.getUid()+" "+userobj.getName()+" "+userobj.getPwd()+" "+userobj.getMobno()+" "+userobj.getEmailid());
   	 		
   	 	}*/
   	    ProductDao productDao= (ProductDao) context.getBean("productDao");
	 	/*Product product=new Product();
	 	product.setId(1);
	 	product.setProductname("Oneplus");
	 	product.setProductdesc("500GB:i5:7th Gen");
	 	product.setQuantity(27);
	 	product.setPrice(40000.00);
	 	//productDao.addProduct(product);
	 	//productDao.updateProduct(product);
	 	//productDao.deleteProduct(6);
	 	//Product p=productDao.selectProduct(2);
	 	//System.out.println(p.getId()+p.getProductname());
	 	List<Product> productList=productDao.getAllProduct();
	 	for(Product productobj:productList)
	 	{
	 		System.out.println(productobj.getId()+" "+productobj.getPrice()+" "+productobj.getProductname()+" "+productobj.getProductdesc()+" "+productobj.getQuantity());
	 	}*/
   	 	
        CategoryDao categoryDao= (CategoryDao)context.getBean("categoryDao");
        /*Category category=new Category();
 	    category.setCategoryId(100);
 	    category.setCategoryname("MOBILE");
 	    category.setCategorydesc("Personal use");
 	    //categoryDao.addCategory(category);
 	    //categoryDao.updateCategory(category);
 	    List<Category> categoryList=categoryDao.getAllCategory();
 	    for(Category categoryobj:categoryList)
 	    {
 		System.out.println(categoryobj.getCategoryId()+" "+categoryobj.getCategoryname()+" "+categoryobj.getCategorydesc());
 	    }*/
 	    SupplierDao supplierDao= (SupplierDao)context.getBean("supplierDao");
 	   /* Supplier supplier=new Supplier();
 	    supplier.setSupplierId(20);
 	    supplier.setSuppliername("cromo electronics");
	    supplier.setSupplierdesc("located at bangalore");
	    //supplierDao.addSupplier(supplier);
	    //supplierDao.updateSupplier(supplier);
	    //Supplier supplierobj=supplierDao.selectSupplier(20);
	   // System.out.println(supplierobj.getSupplierId()+" "+supplierobj.getSuppliername()+" "+supplierobj.getSupplierdesc());
	    List<Supplier> supplierList=supplierDao.getAllSupplier();*/
	     
	     
	 	}
}
