package com.ptlam.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ptlam.dto.LocationDTO;
import com.ptlam.entity.LocationEntity;
import com.ptlam.repository.LocationReposity;
import com.ptlam.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	LocationReposity locationReposity;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional
	public Boolean save(LocationDTO locationDTO) {
		locationReposity.save(locationDTO.getCountry(), locationDTO.getCity());
		return true;
	}

	@Override
	@Transactional
	public LocationDTO findById(UUID locationId) {
		LocationEntity locationEntity =locationReposity.findById(locationId);
		return modelMapper.map(locationEntity, LocationDTO.class);
	}

	@Override
	@Transactional
	public List<LocationDTO> findAll(String key) {
		List<LocationEntity> locationEntities = locationReposity.findAllWithSort(new Sort(Sort.Direction.ASC,key));
		List<LocationDTO> locationDTOs=locationEntities.stream().map((locationEntity)->{return modelMapper.map(locationEntity, LocationDTO.class);}).collect(Collectors.toList());
		return locationDTOs;
	}

	@Override
	public Boolean delete(UUID locationId) {
		locationReposity.delete(locationId);
		return true;
	}

	@Override
	public Boolean update(LocationDTO locationDTO) {
		locationReposity.update(locationDTO.getCountry(), locationDTO.getCity(), locationDTO.getLocationId());
		return true;
	}

}
