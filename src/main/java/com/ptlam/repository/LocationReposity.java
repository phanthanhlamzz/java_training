package com.ptlam.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ptlam.entity.LocationEntity;

public interface LocationReposity extends JpaRepository<LocationEntity, UUID> {
	@Modifying	
	@Query(value="INSERT INTO location (country,city,create_at) VALUES (?,?,CURRENT_TIMESTAMP)",nativeQuery = true)
	Integer save(String country,String city);
	
	@Query(value = "SELECT * FROM location WHERE location_id = ?",nativeQuery = true)
	LocationEntity findById(UUID locationId);
	
	@Query(value = "SELECT l FROM LocationEntity l",nativeQuery = false)
	List<LocationEntity> findAllWithSort(Sort sort);
	
	@Modifying	
	@Query(value="UPDATE location SET country = ?,city = ?, modified_at=CURRENT_TIMESTAMP WHERE location_id=?",nativeQuery = true)
	Integer update(String country,String city,UUID locationId);
}
