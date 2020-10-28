package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvWeightRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvWeightResponseDTO;
/**
 * Service interface for InvWeightService
 * @author Vidya.p
 *
 */

public interface InvWeightService {
	
	/**
	 * Handles fetching of all the InvWeight from DB
	 * 
	 * @return InvWeightResponseDTO
	 */


	List<InvWeightResponseDTO> findAllInvWeight();
	/**
	 * Method that fetches InvWeight according to
	 * 
	 * @param id
	 * @return InvWeightResponseDTO
	 */
	
	InvWeightResponseDTO getInvWeightById(String id);
	
	/**
	 * Service method that persist InvWeight to the DB
	 * 
	 * @param invWeightRequestDTO
	 * @return InvWeightResponseDTO
	 */

	InvWeightResponseDTO saveInvWeight(InvWeightRequestDTO invWeightRequestDTO);
	
	/**
	 * Method that updateInvWeight object in DB
	 * 
	 * @param id
	 * @param inWeightRequestDTO
	 * @return JobProductKeywordsResponseDTO
	 */

	InvWeightResponseDTO updateInvWeight(String id, InvWeightRequestDTO invWeightRequestDTO);
	/**
	 * Fetches InvWeight object list based on a criteria object
	 * 
	 * @param invWeightRequestDTO
	 * @return List<InvWeightResponseDTO>
	 */

	List<InvWeightResponseDTO> findInvWeightByCriteria(InvWeightRequestDTO invWeightRequestDTO) throws Exception;
	
	/**
	 * Deletes a InvWeight object from the DB based on id
	 * 
	 * @param id
	 * @return InvWeightResponseDTO
	 */

	InvWeightResponseDTO deleteInvWeightById(String id);

	
}
