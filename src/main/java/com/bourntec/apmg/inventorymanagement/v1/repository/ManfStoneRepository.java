package com.bourntec.apmg.inventorymanagement.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bourntec.apmg.entity.ManfStone;

/**
 * @author Srijini
 *
 */
@Repository
public interface ManfStoneRepository extends JpaRepository<ManfStone, String> {

}
