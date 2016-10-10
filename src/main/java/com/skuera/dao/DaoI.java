package com.skuera.dao;



import java.util.Date;
import java.util.List;

import com.skuera.entity.CustOrder;

import com.skuera.entity.Product;



public interface DaoI {
	public  List<Product> getProduct();
	public Product getProductById(int pid);
	public int saveOrder(CustOrder ord);
	
public List<CustOrder> searchProduct(int[] ids);
public List<CustOrder> searchProduct(Date date);

	

}
