package com.ptlam.service;

import java.util.List;
import java.util.UUID;

import com.ptlam.dto.LocationDTO;

public interface LocationService {
	Boolean save(LocationDTO locationDTO);
	LocationDTO findById(UUID locationId);
	List<LocationDTO> findAll(String key);
	Boolean delete(UUID locationId);
	Boolean update(LocationDTO locationDTO);
}
