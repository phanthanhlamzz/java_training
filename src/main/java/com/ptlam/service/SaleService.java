package com.ptlam.service;

import java.util.List;
import java.util.UUID;

import com.ptlam.dto.SaleDTO;

public interface SaleService {
	Boolean save(SaleDTO saleDTO);
	SaleDTO findById(UUID saleId);
	List<SaleDTO> findAll(String key);
	Boolean update(SaleDTO saleDTO);
	Boolean delete(UUID saleId);
}
