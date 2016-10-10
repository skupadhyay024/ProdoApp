package com.skuera.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skuera.entity.Product;
import com.skuera.form.ProductForm;
import com.skuera.service.SerI;

/**
 * @author skuera
 *
 */
@Controller
public class OrderController {
	
	
	@Autowired
	private SerI ser;
	
	
	
	public void setSer(SerI ser) {
		this.ser = ser;
	}



	@RequestMapping(value="/addform.view",method=RequestMethod.GET)
	private String getform(Model model){
		System.out.println("I am in controller");
		List<Product> plist=ser.getProduct();
		ProductForm form=new ProductForm();
		Map<Integer,String> promap=new HashMap<Integer, String>();
		model.addAttribute("pform",form);
		for(Product p:plist){
			promap.put(p.getpId(), p.getpName());
		}
		model.addAttribute("catmap",promap);
		
		return "AddOrder";
	}
	
	@RequestMapping(value="/addform.view",method=RequestMethod.POST)
	private String setform(@ModelAttribute("pform") ProductForm form, Model model) {
		
		int a=ser.saveOrder(form);
		if(a==1){
			model.addAttribute("pform",form);
			model.addAttribute("msg","saved Successfully");
			
		}else{
			model.addAttribute("msg","Not saved");
		}
		return "Success";
	}

}
