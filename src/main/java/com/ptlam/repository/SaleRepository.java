package com.ptlam.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ptlam.entity.SaleEntity;

public interface SaleRepository extends JpaRepository<SaleEntity, UUID>{
	@Modifying	
	@Query(value="INSERT INTO sale (product_id,location_id,time_id,dollars,create_at) VALUES (?,?,?,?,CURRENT_TIMESTAMP)",nativeQuery = true)
	Integer save(UUID productId,UUID locationId,UUID timeId,Integer dollars);
	
	@Query(value = "SELECT * FROM sale WHERE sale_id = ?",nativeQuery = true)
	SaleEntity findById(UUID saleId);
	
	@Query(value = "SELECT s FROM SaleEntity s",nativeQuery = false)
	List<SaleEntity> findAllWithSort(Sort sort);
	
	@Modifying	
	@Query(value="UPDATE sale SET location_id = ?,time_id = ?,product_id =?,modified_at=CURRENT_TIMESTAMP WHERE sale_id=?",nativeQuery = true)
	Integer update(UUID locationId,UUID timeId,UUID productId,UUID saleId);
}
