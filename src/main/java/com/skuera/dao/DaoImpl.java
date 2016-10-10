package com.skuera.dao;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skuera.entity.CustOrder;
import com.skuera.entity.Product;


@Repository
@Transactional
public class DaoImpl implements DaoI {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Product> getProduct() {
		 String hql="from Product p";
		List<Product> plist= (List<Product>) sessionFactory.getCurrentSession().createQuery(hql).list();
		 
		return plist;
	}

	@Override
	public Product getProductById(int pid) {
		Product p=(Product) sessionFactory.getCurrentSession().get(Product.class,pid);
		return p;
	}

	@Override
	@Transactional
	public int saveOrder(CustOrder ord) {
		try{
			sessionFactory.getCurrentSession().save(ord);
		return 1;
		}catch(DataAccessException e){
			
		return 0;	
		}
		
	}

	@Override
	public List<CustOrder> searchProduct(int[] ids) {
		
		String str="";
		int i=0;
		Object[] params=new Object[ids.length];
		for(int s:ids){
			str+=",?";
			params[i]=s;
			++i;
		}
		str=str.substring(1);
		String hql="from CustOrder o JOIN o.products op where op.pId in (:prodId)";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
	/*List<Integer> alsit=new ArrayList<>();
		for(int s:ids){
			alsit.add(s);
		}*/
		
		
		query.setParameterList("prodId", params);
		
		System.out.println(query.getQueryString());
		List<Object[]> olist=query.list();
		ArrayList<CustOrder> ord=new ArrayList<>();
		
		for(int l=0;l<olist.size();l++){
			
			ord.add((CustOrder) olist.get(l)[0]);
		}

		
		return  ord;
	}

	@Override
	public List<CustOrder> searchProduct(Date date) {
		String hql="from CustOrder o where o.date=:date";
	
		
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("date", date);
		List<CustOrder> pdlist=query.list();
		

		
		return pdlist;
	}

	
	

}
