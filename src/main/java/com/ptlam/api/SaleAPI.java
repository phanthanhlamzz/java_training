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

import com.ptlam.dto.SaleDTO;
import com.ptlam.service.SaleService;

@RestController
public class SaleAPI {
	
	@Autowired
	SaleService saleService;
	
	@PostMapping(value = {"/api/sale"})
	public Boolean save(@RequestBody SaleDTO saleDTO) {
		return saleService.save(saleDTO);
	}
	
	@GetMapping(value = {"/api/sale/{saleId}"})
	public SaleDTO findById(@PathVariable(name = "saleId") UUID saleId ) {
		return saleService.findById(saleId);
		//return null;
	}
	
	@GetMapping(value = {"/api/sale"})
	public List<SaleDTO> findAllWithSort(){
		return saleService.findAll("saleId");
		//return null;
	}
	@PutMapping(value = {"/api/sale"})
	public Boolean updateSale(@RequestBody SaleDTO saleDTO) {
		return saleService.update(saleDTO);
	}
	@DeleteMapping(value= {"/api/sale/{saleId}"})
	public Boolean deleteSale(@PathVariable(name = "saleId") UUID saleId) {
		return saleService.delete(saleId);
	}
}
