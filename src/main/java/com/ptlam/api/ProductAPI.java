package com.ptlam.api;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ptlam.dto.ProductDTO;
import com.ptlam.service.ProductService;

@RestController
public class ProductAPI {
	
	@Autowired
	ProductService productService;
	
	@GetMapping(value = {"/api/product/{productId}"})
	public ProductDTO getProductById(@PathVariable(name = "productId") UUID productId ) {
		return productService.findById(productId);
		//return null;
	}
	
	@GetMapping(value = {"/api/product"})
	public List<ProductDTO> getAllProduct(){
		return productService.findAllWithSort("productId");
		//return null;
	}
	
	@PostMapping(value = {"/api/product"})
	public Boolean saveProduct(@RequestBody ProductDTO productDTO) {
		return productService.save(productDTO);
	}
	
	@DeleteMapping(value= {"/api/product/{productId}"})
	public Boolean deleteProduct(@PathVariable(name = "productId") UUID productId) {
		return productService.deleteById(productId);
	}
	
	@PutMapping(value = {"/api/product"})
	public Boolean updateProduct(@RequestBody ProductDTO productDTO) {
		return productService.update(productDTO);
	}
}
