package com.ptlam.service;

import java.util.List;
import java.util.UUID;

import com.ptlam.dto.TimeDTO;

public interface TimeService {
	Boolean save(TimeDTO timeDTO);
	TimeDTO findById(UUID timeId);
	List<TimeDTO> findAll(String key);
	Boolean delete(UUID timeId);
	Boolean update(TimeDTO timeDTO);
}
