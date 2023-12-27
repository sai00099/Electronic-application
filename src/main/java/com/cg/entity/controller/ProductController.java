package com.cg.entity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Product;
import com.cg.exceptions.ResourceNotFoundException;
import com.cg.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/add-product")
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return new ResponseEntity<>("Product added succesfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/remove-product")
	public ResponseEntity<?> removeProduct(@RequestParam int productid) throws ResourceNotFoundException {
		productService.removeProduct(productid);
		return new ResponseEntity<>("Product deleted succesfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-product-by-id")
	public ResponseEntity<?> getProductById(@RequestParam int productId) throws ResourceNotFoundException {
		return ResponseEntity.ok(productService.getProduct(productId));
	}

	@PutMapping("/update-product")
	public ResponseEntity<?> updateProduct(@RequestBody Product p, @RequestParam int productId)
			throws ResourceNotFoundException {
		productService.updateProductWarranty(productId, p);
		return new ResponseEntity<>("updated Product successfully", HttpStatus.ACCEPTED);
	}

	@GetMapping("/get-product-complaints")
	public ResponseEntity<?> getProductComplaints(@RequestParam int productId) {
		return ResponseEntity.ok(productService.getProductsComplaints(productId));
	}

}
