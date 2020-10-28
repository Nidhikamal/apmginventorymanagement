package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvUnitChargeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvUnitChargeResponseDTO;

public interface InvUnitChargeService {
	/**
	 * Service method that persist Inv Unit Charge to the DB
	 * 
	 * @param invUnitChargeRequestDTO
	 * @return
	 */
	InvUnitChargeResponseDTO saveInvUnitCharge(InvUnitChargeRequestDTO invUnitChargeRequestDTO);
	
	/**
	 * Method that updates Inv Unit Charge object in DB
	 * 
	 * @param unitCharge
	 * @param invUnitChargeRequestDTO
	 * @return
	 */
	InvUnitChargeResponseDTO updateInvUnitCharge(String unitCharge,
			InvUnitChargeRequestDTO invUnitChargeRequestDTO);
	/**
	 * Method that fetches Inv Unit Charge according to
	 * 
	 * @param unitCharge
	 * @return
	 */
	InvUnitChargeResponseDTO getById(String unitCharge);
	/**
	 * Handles the fetching of all the Inv Unit Charge in DB
	 * 
	 * @return
	 */
	List<InvUnitChargeResponseDTO> getAll();
	
	/**
	 * Fetches a Inv Unit Charge object based on a criteria object
	 * 
	 * @param manifestRequestDTO
	 * @return
	 */
	List<InvUnitChargeResponseDTO> fetchByInvUnitCharge(InvUnitChargeRequestDTO invUnitChargeRequestDT) throws Exception;
	/**
	 * Deletes a memo Manifest object from the DB based on
	 * 
	 * @param id
	 * @return 
	 */
	InvUnitChargeResponseDTO deleteInvUnitCharge(String unitCharge);}
