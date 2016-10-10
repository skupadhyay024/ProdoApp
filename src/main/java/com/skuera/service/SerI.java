package com.skuera.service;

import java.util.List;

import com.skuera.entity.CustOrder;
import com.skuera.entity.Product;
import com.skuera.form.ProductForm;
import com.skuera.form.SearchForm;

public interface SerI {
	public List<Product> getProduct();
	public int saveOrder(ProductForm frm);
	public List<CustOrder> searchOrder(SearchForm frm);

}
