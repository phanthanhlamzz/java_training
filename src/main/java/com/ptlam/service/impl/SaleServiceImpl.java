package com.ptlam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ptlam.dto.SaleDTO;
import com.ptlam.entity.SaleEntity;
import com.ptlam.repository.SaleRepository;
import com.ptlam.service.SaleService;

@Service
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	SaleRepository saleRepository;
	
	@Override
	@Transactional
	public Boolean save(SaleDTO saleDTO) {
		saleRepository.save(saleDTO.getProductId(), saleDTO.getLocationId(), saleDTO.getTimeId(), saleDTO.getDollars());
		return true;
	}

	@Override
	public SaleDTO findById(UUID saleId) {
		SaleEntity saleEntity = saleRepository.findById(saleId);
		SaleDTO saleDTO = new SaleDTO();
		saleDTO.setCreateAt(saleEntity.getCreateAt());
		saleDTO.setDollars(saleEntity.getDollars());
		saleDTO.setLocationId(saleEntity.getLocationEntity().getLocationId());
		saleDTO.setModifiedAt(saleEntity.getModifiedAt());
		saleDTO.setProductId(saleEntity.getProductEntity().getProductId());
		saleDTO.setSaleId(saleEntity.getSaleId());
		saleDTO.setTimeId(saleEntity.getTimeEntity().getTimeId());
		return saleDTO;
	}

	@Override
	public List<SaleDTO> findAll(String key) {
		List<SaleEntity> saleEntities = saleRepository.findAllWithSort(new Sort(Sort.Direction.ASC,key));
		List<SaleDTO> saleDTOs = new ArrayList<SaleDTO>();
		for(SaleEntity saleEntity : saleEntities) {
			SaleDTO saleDTO = new SaleDTO();
			saleDTO.setCreateAt(saleEntity.getCreateAt());
			saleDTO.setDollars(saleEntity.getDollars());
			saleDTO.setLocationId(saleEntity.getLocationEntity().getLocationId());
			saleDTO.setModifiedAt(saleEntity.getModifiedAt());
			saleDTO.setProductId(saleEntity.getProductEntity().getProductId());
			saleDTO.setSaleId(saleEntity.getSaleId());
			saleDTO.setTimeId(saleEntity.getTimeEntity().getTimeId());
			saleDTOs.add(saleDTO);
		}
		return saleDTOs;
	}

	@Override
	public Boolean update(SaleDTO saleDTO) {
		saleRepository.update(saleDTO.getLocationId(), saleDTO.getTimeId(), saleDTO.getProductId(), saleDTO.getSaleId());
		return true;
	}

	@Override
	public Boolean delete(UUID saleId) {
		saleRepository.delete(saleId);
		return true;
	}

}
