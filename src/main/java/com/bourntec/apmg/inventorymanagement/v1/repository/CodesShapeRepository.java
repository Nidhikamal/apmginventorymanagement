package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CodesShapes;
@Repository("CodeShapeRepository")
public interface CodesShapeRepository 
extends JpaRepository<CodesShapes, String>,JpaSpecificationExecutor  {

}
