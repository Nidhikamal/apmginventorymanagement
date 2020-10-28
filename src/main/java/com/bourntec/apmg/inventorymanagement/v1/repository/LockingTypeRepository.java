package com.bourntec.apmg.inventorymanagement.v1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
 
import com.bourntec.apmg.entity.LockingType;
@Repository("LockingTypeRepository")

public interface LockingTypeRepository extends JpaRepository<LockingType, Long>, JpaSpecificationExecutor<LockingType> {
	@Query("FROM LockingType WHERE category = ?1")
	List<LockingType> findLockingTypeByCategory(String categoryId);

}
