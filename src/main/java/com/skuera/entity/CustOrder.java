package com.skuera.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author skuera
 *
 */
@Entity
@Table(name="cust_order")
public class CustOrder {

	
	@Id
	@GeneratedValue
	@Column(name="o_id")
	private int oId;
	
	@Column(name="o_date")
	private Date date;
	
	@Column(name="cust_name")
	private String custName;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="product_order", 
			   joinColumns={@JoinColumn(name="o_id", referencedColumnName = "o_id")},
			   inverseJoinColumns={@JoinColumn(name="prod_id",referencedColumnName = "prod_id")})
	private Set<Product> products=new HashSet<>();


	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((custName == null) ? 0 : custName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + oId;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustOrder other = (CustOrder) obj;
		if (custName == null) {
			if (other.custName != null)
				return false;
		} else if (!custName.equals(other.custName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (oId != other.oId)
			return false;
		return true;
	}
	
	
	

}
