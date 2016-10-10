package com.skuera.entity;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 * @author skuera
 *
 */
@Entity
@Table(name="product")
public class Product{
	
	
	@Id
	@GeneratedValue
	@Column(name="prod_id")
	private int pId;
	
	@Column(name="prod_name")
	private String pName;
	
	@Column(name="prod_price")
	private Double price;
	
	@ManyToMany(mappedBy = "products")
	private Set<CustOrder> custorders=new HashSet<>();
	
	

	public Set<CustOrder> getCustorders() {
		return custorders;
	}
	public void setCustorders(Set<CustOrder> custorders) {
		this.custorders = custorders;
	}

	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	


}
