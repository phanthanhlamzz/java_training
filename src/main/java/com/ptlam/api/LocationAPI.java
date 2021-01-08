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

import com.ptlam.dto.LocationDTO;
import com.ptlam.service.LocationService;

@RestController
public class LocationAPI {

	@Autowired
	LocationService locationService;
	
	@PostMapping(value = {"/api/location"})
	public Boolean saveLocation(@RequestBody LocationDTO locationDTO) {
		return locationService.save(locationDTO);
	}
	
	@GetMapping(value = {"/api/location/{locationId}"})
	public LocationDTO findById(@PathVariable(name = "locationId") UUID locationId ) {
		return locationService.findById(locationId);
		//return null;
	}
	
	@PutMapping(value = {"/api/location"})
	public Boolean updateLocation(@RequestBody LocationDTO locationDTO) {
		return locationService.update(locationDTO);
	}
	
	@GetMapping(value = {"/api/location"})
	public List<LocationDTO> findAllWithSort(){
		return locationService.findAll("locationId");
		//return null;
	}
	
	@DeleteMapping(value= {"/api/location/{locationId}"})
	public Boolean deleteLocation(@PathVariable("locationId") UUID locationId) {
		return locationService.delete(locationId);
	}
}
