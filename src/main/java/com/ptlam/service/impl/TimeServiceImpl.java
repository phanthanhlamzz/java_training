package com.ptlam.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ptlam.dto.TimeDTO;
import com.ptlam.entity.TimeEntity;
import com.ptlam.repository.TimeRepository;
import com.ptlam.service.TimeService;

@Service
public class TimeServiceImpl implements TimeService{

	@Autowired
	TimeRepository timeRepository;
	
	private ModelMapper modelMapper = new ModelMapper();
	
	@Override
	@Transactional
	public Boolean save(TimeDTO timeDTO) {
		timeRepository.save(timeDTO.getMonth(), timeDTO.getQuarter(), timeDTO.getYear());
		return true;
	}

	@Override
	@Transactional
	public TimeDTO findById(UUID timeId) {
		TimeEntity timeEntity =timeRepository.findById(timeId);
		return modelMapper.map(timeEntity, TimeDTO.class);
	}

	@Override
	@Transactional
	public List<TimeDTO> findAll(String key) {
		List<TimeEntity> timeEntities = timeRepository.findAllWithSort(new Sort(Sort.Direction.ASC,key));
		List<TimeDTO> timeDTOs=timeEntities.stream().map((timeEntity)->{return modelMapper.map(timeEntity, TimeDTO.class);}).collect(Collectors.toList());
		return timeDTOs;
	}

	@Override
	public Boolean delete(UUID timeId) {
		timeRepository.delete(timeId);
		return true;
	}

	@Override
	public Boolean update(TimeDTO timeDTO) {
		timeRepository.update(timeDTO.getMonth(), timeDTO.getQuarter(), timeDTO.getYear(), timeDTO.getTimeId());
		return true;
	}

}
