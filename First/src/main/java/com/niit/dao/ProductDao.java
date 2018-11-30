package com.niit.dao;

import java.util.List;

import com.niit.model.Product;
import com.niit.model.User;

public interface ProductDao
{
	public Product addProduct(Product product);
    public void updateProduct(Product product);
    public void deleteProduct(int id);
    public Product selectProduct(int id);
    public List<Product>getAllProduct();

}   
