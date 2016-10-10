package com.skuera.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skuera.dao.DaoI;
import com.skuera.entity.CustOrder;
import com.skuera.entity.Product;
import com.skuera.form.ProductForm;
import com.skuera.form.SearchForm;

@Service
@Transactional
public class SerImpl implements SerI{
	
	@Autowired
	private DaoI dao;
	
	

	public void setDao(DaoI dao) {
		this.dao = dao;
	}



	@Override
	public List<Product> getProduct() {
		
		return dao.getProduct();
	}



	@Override
	public int saveOrder(ProductForm frm) {
	 CustOrder order=new CustOrder();
	 order.setoId(Integer.parseInt(frm.getoId()));
	 order.setCustName(frm.getCustName());
	 String date=frm.getoDate();
	 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	 Date d=null;
	 try {
		d=sdf.parse(date);
		//java.sql.Date sqldate=new java.sql.Date(d.getTime());
		order.setDate(d);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 HashSet<Product> prodset=new HashSet<Product>();
	for(int s:frm.getProducts()){
		Product p=dao.getProductById(s);
		order.getProducts().add(p);
		//prodset.add(p);
		
	}
	//order.setProducts(prodset);
	int t=dao.saveOrder(order);
	return t;
	}



	@Override
	public List<CustOrder> searchOrder(SearchForm frm) {
		String dt=frm.getOrdDate();
		SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
		
		
		if(frm.getPid().length==0 && frm.getOrdDate()!=null){
		
		List<CustOrder> olist=new ArrayList<CustOrder>();
		try {
			Date d=sdf.parse(dt);
		 olist=dao.searchProduct(d);
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return olist;
		
	}else if(frm.getPid().length>0 && frm.getOrdDate().equals("")){
		List<CustOrder> olist=dao.searchProduct(frm.getPid());
		return olist;
	}else{
		String ds=frm.getOrdDate();
		SimpleDateFormat sd= new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date d = sd.parse(ds);
			List<CustOrder> olist=dao.searchProduct(d);
			return olist;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	
		
		
	
		
		
	}

	

}
}
