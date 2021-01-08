package com.ptlam.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ptlam.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
	
	@Query(value = "SELECT * FROM product WHERE product_id= :productId",nativeQuery = true)
	ProductEntity findById(@Param("productId") UUID productId);
	
	@Query(value = "SELECT p FROM ProductEntity p",nativeQuery = false)
	List<ProductEntity> findAllWithSort(Sort sort);
	
	@Modifying	
	@Query(value="INSERT INTO product (item,class,inventory,create_at) VALUES (?,?,?,CURRENT_TIMESTAMP)",nativeQuery = true)
	Integer saveProduct(Integer item,String zclass,String inventory);
	
	@Modifying	
	@Query(value="UPDATE product SET item=?1,class=?2,inventory=?3,modified_at=CURRENT_TIMESTAMP WHERE product_id=?4",nativeQuery = true)
	Integer updateProduct(Integer item,String zclass,String inventory,UUID productId);
}
