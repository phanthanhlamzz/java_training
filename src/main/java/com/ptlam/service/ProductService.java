package com.ptlam.service;

import java.util.List;
import java.util.UUID;

import com.ptlam.dto.ProductDTO;


public interface ProductService {
	ProductDTO findById(UUID productId);
	List<ProductDTO> findAllWithSort(String key);
	Boolean save(ProductDTO productDTO);
	Boolean deleteById(UUID productId);
	Boolean update(ProductDTO productDTO);
}
