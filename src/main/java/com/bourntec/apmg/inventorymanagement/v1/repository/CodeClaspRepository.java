package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.CodeClasp;

@Repository("CodeClaspRepository")
public interface CodeClaspRepository  extends JpaRepository<CodeClasp, String>,JpaSpecificationExecutor<CodeClasp>{

}
