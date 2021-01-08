package com.ptlam.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ptlam.entity.TimeEntity;

public interface TimeRepository extends JpaRepository<TimeEntity, UUID> {
	@Modifying	
	@Query(value="INSERT INTO time (month,quarter,year,create_at) VALUES (?,?,?,CURRENT_TIMESTAMP)",nativeQuery = true)
	Integer save(Integer month,Integer quarter,Integer year);
	
	@Query(value = "SELECT * FROM time WHERE time_id = ?",nativeQuery = true)
	TimeEntity findById(UUID timeId);
	
	@Query(value = "SELECT t FROM TimeEntity t",nativeQuery = false)
	List<TimeEntity> findAllWithSort(Sort sort);
	
	@Modifying	
	@Query(value="UPDATE time SET month = ?,quarter = ?, year= ? ,modified_at=CURRENT_TIMESTAMP WHERE time_id=?",nativeQuery = true)
	Integer update(Integer month,Integer quarter,Integer year,UUID timeId);
	
}
