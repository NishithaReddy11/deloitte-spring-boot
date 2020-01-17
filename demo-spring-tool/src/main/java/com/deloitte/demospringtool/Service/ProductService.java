package com.deloitte.demospringtool.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deloitte.demospringtool.Model.Product;
import com.deloitte.demospringtool.Repo.ProductRepo;
@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	public Product saveProduct(Product product)
	{
		return repo.save(product);
	}
	
	public List<Product> getAllProducts()
	{
		return repo.findAll();
	}
	public Product getProductById(int pId)
	{
		return repo.getOne(pId);

	}
	
	public Product getProductByName(String pName)
	{
		return repo.findByproductName(pName);

	}
	public Product getProductByNameAndPrice(String pName,float price)
	{
		return repo.findByproductNameAndPrice(pName,price);

	}
	public List<Product> getProductsInRange(float from,float to)
	{
		return repo.findProductsInRange(from,to);
	}
	
}
