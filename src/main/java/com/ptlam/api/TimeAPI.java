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

import com.ptlam.dto.TimeDTO;
import com.ptlam.service.TimeService;

@RestController
public class TimeAPI {
	
	@Autowired
	TimeService timeService;
	
	@PostMapping(value = {"/api/time"})
	public Boolean saveTime(@RequestBody TimeDTO timeDTO) {
		return timeService.save(timeDTO);
	}
	
	@GetMapping(value = {"/api/time/{timeId}"})
	public TimeDTO findById(@PathVariable(name = "timeId") UUID timeId ) {
		return timeService.findById(timeId);
		//return null;
	}
	
	@GetMapping(value = {"/api/time"})
	public List<TimeDTO> findAllWithSort(){
		return timeService.findAll("timeId");
	}
	
	@DeleteMapping(value= {"/api/time/{timeId}"})
	public Boolean deleteTime(@PathVariable("timeId") UUID timeId) {
		return timeService.delete(timeId);
	}
	
	@PutMapping(value = {"/api/time"})
	public Boolean updateTime(@RequestBody TimeDTO timeDTO) {
		return timeService.update(timeDTO);
	}
	
}
