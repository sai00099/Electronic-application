package com.cg.service;

import java.util.List;

import com.cg.entity.Complaint;
import com.cg.entity.Product;
import com.cg.exceptions.ResourceNotFoundException;

public interface ProductService {

	Boolean addProduct(Product product);

	Boolean removeProduct(int pid) throws ResourceNotFoundException;

	Product getProduct(int pid) throws ResourceNotFoundException;

	String updateProductWarranty(int pid, Product product) throws ResourceNotFoundException;

	List<Complaint> getProductsComplaints(int pid);
	
	//List<Engineer> getEngineersByProduct(int eid);
}
