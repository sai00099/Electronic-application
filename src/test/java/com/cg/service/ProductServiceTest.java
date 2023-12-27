package com.cg.service;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Product;
import com.cg.entity.repository.ProductRepo;
import com.cg.exceptions.ResourceNotFoundException;

@SpringBootTest
class ProductServiceTest {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepo productRepo;

	@Test
	void testAddProduct() {
		Product p = new Product(300, "v212", "Mi", "smartphone", LocalDate.now(), 1, LocalDate.of(2024, 01, 30));
		productRepo.save(p);
		assertEquals(true, productService.addProduct(p));
		productRepo.delete(p);
	}

	@Test
	void testRemoveProduct() throws ResourceNotFoundException {
		Product p = new Product(300, "v212", "Mi", "smartphone", LocalDate.now(), 1, LocalDate.of(2024, 01, 30));
		productRepo.save(p);
		assertEquals(true, productService.removeProduct(p.getProductId()));

	}

	@Test
	void testGetProduct() throws ResourceNotFoundException {
		Product p = new Product(300, "v212", "Mi", "smartphone", LocalDate.now(), 1, LocalDate.of(2024, 01, 30));
		productRepo.save(p);
		assertEquals(p, productService.getProduct(p.getProductId()));
		productRepo.delete(p);

	}

	@Test
	void testUpdateProductWarranty() throws ResourceNotFoundException {
		Product p = new Product(300, "v212", "Mi", "smartphone", LocalDate.now(), 1, LocalDate.of(2024, 01, 30));
		productRepo.save(p);
		// updating the warranty of the product
		Product updatedProduct = new Product(300, "v212", "mi", "smartphone", LocalDate.now(), 2,
				LocalDate.of(2025, 01, 30));

		assertEquals("Product updated", productService.updateProductWarranty(300, updatedProduct));
		productRepo.delete(updatedProduct);

	}

}
