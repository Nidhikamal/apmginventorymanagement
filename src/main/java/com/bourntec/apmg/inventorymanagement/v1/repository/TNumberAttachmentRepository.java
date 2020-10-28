package com.bourntec.apmg.inventorymanagement.v1.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.TNumberAttachment;



/**
 * 
 * Repository for carried out crud operations of TNumberAttachment Entity
 * @author Srijini
 *
 */
@Repository(value = "TNumberAttachmentRepository")
public interface TNumberAttachmentRepository extends JpaRepository<TNumberAttachment, Long>, JpaSpecificationExecutor<TNumberAttachment>{
}
