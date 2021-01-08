package com.ptlam.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ptlam.dto.ProductDTO;
import com.ptlam.entity.ProductEntity;
import com.ptlam.repository.ProductRepository;
import com.ptlam.repository.SaleRepository;
import com.ptlam.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {	
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	SaleRepository saleRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional
	public ProductDTO findById(UUID productId) {
		ProductEntity productEntity = productRepository.findOne(productId);
		ProductDTO productDTO =  modelMapper.map(productEntity, ProductDTO.class);
		return productDTO;
	}

	@Override
	@Transactional
	public List<ProductDTO> findAllWithSort(String key) {
		List<ProductEntity> productEntities = productRepository.findAllWithSort(new Sort(Sort.Direction.ASC, key));
		return productEntities.stream().map(product -> {return modelMapper.map(product, ProductDTO.class);}).collect(Collectors.toList());
		//return null;
	}

	@Override
	@Transactional
	public Boolean save(ProductDTO productDTO) {
//		ProductEntity productEntity = modelMapper.map(productDTO, ProductEntity.class);
//		ProductEntity newProductEntity= productRepository.save(productEntity);
		productRepository.saveProduct(productDTO.getItem(),productDTO.getZclass(),productDTO.getInventory());
		//return modelMapper.map(newProductEntity, ProductDTO.class);
		return true;
	}

	@Override
	@Transactional
	public Boolean deleteById(UUID productId) {
		ProductEntity productEntity = productRepository.getOne(productId);
		saleRepository.delete(productEntity.getSaleEntities());
		productRepository.delete(productEntity);
		return true;
	}

	@Override
	@Transactional
	public Boolean update(ProductDTO productDTO) {
		productRepository.updateProduct(productDTO.getItem(), productDTO.getZclass(), productDTO.getInventory(), productDTO.getProductId());
		return true;
	}
}
