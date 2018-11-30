package com.niit.dao;

import java.util.List;

import com.niit.model.Supplier;

public interface SupplierDao 
{
	public Supplier addSupplier(Supplier supplier);
    public void updateSupplier(Supplier supplier);
    public void deleteSupplier(int id);
    public Supplier selectSupplier(int id);
    public List<Supplier> getAllSupplier();
}
