package com.niit.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;
import com.niit.model.User;

@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao
{
	
	@Autowired
	SessionFactory sessionFactory;
		public Product addProduct(Product product) 
		{
			sessionFactory.getCurrentSession().save(product);
			return product;
        }
		public void updateProduct(Product product) 
		{
		  sessionFactory.getCurrentSession().update(product);
		
			}
		public void deleteProduct(int id) {
			Session session=sessionFactory.getCurrentSession();
			Product p=(Product)session.get(Product.class,id);
			session.delete(p);
		}
		public Product selectProduct(int id )
		{
			Object obj=sessionFactory.getCurrentSession().get(Product.class,id);
			Product p=(Product)obj;
			return p;
		} 

		public List<Product> getAllProduct() {
			 return  sessionFactory.getCurrentSession().createQuery("from Product").list();
		}
		
		

}
