package com.skuera.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.skuera.entity.CustOrder;

import com.skuera.entity.Product;
import com.skuera.form.SearchForm;
import com.skuera.service.SerI;

/**
 * @author skuera
 *
 */
@Controller
@SessionAttributes({"sform","cmap"})
public class SearchController {
	
	
	@Autowired
	private SerI ser;

     public void setSer(SerI ser) {
		this.ser = ser;
	}
	
     @RequestMapping(value="/sform.view",method=RequestMethod.GET)
     public String getSearchForm(Model model){
    	List<Product> plist= ser.getProduct();
    	SearchForm form=new SearchForm();
    	Map<Integer,String> catmap=new HashMap<Integer, String>();
    	for(Product p:plist){
    		catmap.put(p.getpId(), p.getpName());
    	}
    	model.addAttribute("cmap",catmap );
    	model.addAttribute("sform", form);
    	 
    	 
    	 
    	 
		return "Search";
    	 
     }
     @RequestMapping(value="/sform.view",method=RequestMethod.POST)
     public String getSearchForm(@ModelAttribute("sform") SearchForm form ,Model model){
    	List<CustOrder> ilist= new ArrayList<CustOrder>();
    	ilist=ser.searchOrder(form);
    	for(CustOrder s:ilist){
    		System.out.println(s.getCustName());
    	}
    	HashSet<CustOrder> olist=new HashSet<>(ilist); 
    	model.addAttribute("plist",olist);
    	return "Search";
		
     }
	

}
