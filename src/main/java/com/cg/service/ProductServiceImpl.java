package com.cg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Complaint;
import com.cg.entity.Product;
import com.cg.entity.repository.ComplaintRepo;
import com.cg.entity.repository.ProductRepo;
import com.cg.exceptions.ResourceNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;
	@Autowired
	private ComplaintRepo complaintRepo;

	@Override
	public Boolean addProduct(Product product) {
		productRepo.save(product);

		return true;
	}

	@Override
	public Boolean removeProduct(int pid) throws ResourceNotFoundException {
		Product p = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id : " + pid));
		productRepo.delete(p);
		return true;
	}

	@Override
	public Product getProduct(int pid) throws ResourceNotFoundException {
		Product p = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id : " + pid));
		return p;
	}

	@Override
	public String updateProductWarranty(int pid, Product product) throws ResourceNotFoundException {
		Product p = productRepo.findById(pid)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found with id : " + pid));
		productRepo.delete(p);
		product.setProductId(pid);
		productRepo.save(product);

		return "Product updated";
	}

	@Override
	public List<Complaint> getProductsComplaints(int pid) {

		List<Complaint> l = complaintRepo.findAll();
		List<Complaint> clist = new ArrayList<>();
		try {
			for (int i = 0; i < l.size(); i++) {
				int pSize = l.get(i).getClient().getProduct().size();
				for (int j = 0; j < pSize; j++) {
					if (l.get(i).getClient().getProduct().get(j).getProductId() == pid) {
						clist.add(l.get(i));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return clist;
	}

}
