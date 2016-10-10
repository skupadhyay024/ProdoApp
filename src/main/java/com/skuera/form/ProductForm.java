package com.skuera.form;

public class ProductForm {
	private String oId;
	private String custName;
	private String oDate;
	private int[] products;
	public String getoId() {
		return oId;
	}
	public void setoId(String oId) {
		this.oId = oId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getoDate() {
		return oDate;
	}
	public void setoDate(String oDate) {
		this.oDate = oDate;
	}
	public int[] getProducts() {
		return products;
	}
	public void setProducts(int[] products) {
		this.products = products;
	}

	

}
