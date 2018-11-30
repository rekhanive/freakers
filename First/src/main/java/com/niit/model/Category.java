package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int CategoryId;
	String Categoryname;
	String Categorydesc;
	public int getCategoryId() {
		return CategoryId;
	}
	public void setCategoryId(int categoryId) {
		this.CategoryId = categoryId;
	}
	public String getCategoryname() {
		return Categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.Categoryname = categoryname;
	}
	public String getCategorydesc() {
		return Categorydesc;
	}
	public void setCategorydesc(String categorydesc) {
		this.Categorydesc = categorydesc;
	}
	
	
	
}