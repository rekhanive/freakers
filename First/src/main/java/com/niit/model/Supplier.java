package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier 
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  int SupplierId;
  String Suppliername;
  String Supplierdesc;
public int getSupplierId() {
	return SupplierId;
}
public void setSupplierId(int supplierId) {
	this.SupplierId = supplierId;
}
public String getSuppliername() {
	return Suppliername;
}
public void setSuppliername(String suppliername) {
	this.Suppliername = suppliername;
}
public String getSupplierdesc() {
	return Supplierdesc;
}
public void setSupplierdesc(String supplierdesc) {
	this.Supplierdesc = supplierdesc;
}
}
