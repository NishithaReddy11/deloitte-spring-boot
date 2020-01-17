package com.deloitte.client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.deloitte.client.Model.Product;

@Controller
public class ClientController {

	
		@PostMapping("/addproduct")
		public String addProduct( @ModelAttribute Product product,Model m)
		{
			
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Product> entity=
			rt.postForEntity("http://localhost:8888/products",product,Product.class);
			
			m.addAttribute("entity",entity);
			
			return "show.jsp";
			
		}
		
		@GetMapping("/searchproduct")
		public String getProductById(@RequestParam("txtpId")int id,Model m)
		{
			RestTemplate rt=new RestTemplate();
			ResponseEntity<Product> entity=
					rt.getForEntity("http://localhost:8888/products/"+id,Product.class);
			m.addAttribute("entity",entity);
			return "showproduct.jsp";
		}
		
}
