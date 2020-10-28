package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryFindingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryFindingResponseDTO;
/**
 * Service interface for InventoryLibraryFindingService
 * @author Vidya.p
 *
 */

public interface InventoryLibraryFindingService {
	
	/**
	 * Handles fetching of all the InventoryLibraryFinding Finding from DB
	 * 
	 * @return InventoryLibraryFindingResponseDTO
	 */


	List<InventoryLibraryFindingResponseDTO> findAllInventoryLibraryFinding();
	/**
	 * Method that fetches InventoryLibraryFinding Finding according to
	 * 
	 * @param id
	 * @return InventoryLibraryFindingResponseDTO
	 */
	
	InventoryLibraryFindingResponseDTO getInventoryLibraryFindingById(Long id);
	
	/**
	 * Service method that persist InventoryLibraryFinding Finding to the DB
	 * 
	 * @param inventoryLibraryRequestDTO
	 * @return InventoryLibraryFindingResponseDTO
	 */

	InventoryLibraryFindingResponseDTO saveInventoryLibraryFinding(InventoryLibraryFindingRequestDTO inventoryLibraryRequestDTO);
	
	/**
	 * Method that updateInventoryLibraryFinding object in DB
	 * 
	 * @param id
	 * @param inventoryLibraryRequestDTO
	 * @return inventoryLibraryFindingResponseDTO
	 */

	InventoryLibraryFindingResponseDTO updateInventoryLibraryFinding(Long id, InventoryLibraryFindingRequestDTO inventoryLibraryRequestDTO);
	/**
	 * Fetches InventoryLibraryFinding Finding object list based on a criteria object
	 * 
	 * @param inventoryLibraryRequestDTO
	 * @return List<InventoryLibraryFindingResponseDTO>
	 */

	List<InventoryLibraryFindingResponseDTO> findInventoryLibraryFindingByCriteria(InventoryLibraryFindingRequestDTO inventoryLibraryRequestDTO) throws Exception;
	
	/**
	 * Deletes a InventoryLibraryFinding Finding object from the DB based on id
	 * 
	 * @param id
	 * @return InventoryLibraryFindingResponseDTO
	 */

	InventoryLibraryFindingResponseDTO deleteInventoryLibraryFindingById(Long id);

	
}
