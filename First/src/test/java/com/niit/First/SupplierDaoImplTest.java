package com.niit.First;




import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.config.DBConfig;
import com.niit.dao.SupplierDao;
import com.niit.daoImpl.SupplierDaoImpl;
import com.niit.model.Category;
import com.niit.model.Supplier;

import junit.framework.TestCase;

public class SupplierDaoImplTest extends TestCase 
{
	ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class,SupplierDaoImpl.class);
	SupplierDao supplierDao=(SupplierDao)context.getBean("supplierDao");
	   public void testSaveSupplier() 
	    {
		Supplier supplier =new Supplier();
		supplier.setSupplierId(37);
		supplier.setSuppliername("vasanth enterpreses");
		supplier.setSupplierdesc("located in russia");
		supplier=supplierDao.addSupplier(supplier);
		assertTrue(supplier.getSupplierId()>0); 
		
	}
	    
	    public void testUpdateSupplier() 
        {
	    Supplier supplier=supplierDao.selectSupplier(20);
	    supplier.setSuppliername("croma");
	    supplier.setSupplierdesc("located in kanada");
	    supplierDao.updateSupplier(supplier);
		assertTrue(supplier.getSuppliername().equals("croma"));
		assertTrue(supplier.getSupplierdesc().equals("located in kanada"));
	}
	    
	    public void testGetSupplier()
        {
    	  Supplier supplier1=supplierDao.selectSupplier(35);
    	  Supplier supplier2=supplierDao.selectSupplier(32);
    	  Supplier supplier3=supplierDao.selectSupplier(5);
    	  assertNotNull(supplier1);
    	  assertNotNull(supplier2);
    	  assertNull(supplier3);
    	  String expectedname=" vasanthco";
    	  String actualname=supplier1.getSuppliername();
    	  System.out.println(supplier1.getSuppliername());
    	  assertTrue(expectedname.equals(actualname));
       }
	    
	    public void testDeleteSupplier()
        {
	    supplierDao.deleteSupplier(29);  
     	assertNull(supplierDao.selectSupplier(29));
        }
        public void testGetAllSupplier()
        {
         List<Supplier> supplierList=supplierDao.getAllSupplier(); 
         assertNotNull(supplierList.isEmpty());
        }
        
        
	
	
	

}
