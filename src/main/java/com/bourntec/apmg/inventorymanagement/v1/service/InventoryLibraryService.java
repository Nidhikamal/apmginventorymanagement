package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryResponseDTO;
/**
 * Service interface for InventoryLibraryService
 * @author Vidya.p
 *
 */

public interface InventoryLibraryService {
	
	/**
	 * Handles fetching of all the InventoryLibrary from DB
	 * 
	 * @return InventoryLibraryResponseDTO
	 */


	List<InventoryLibraryResponseDTO> findAllInventoryLibrary();
	/**
	 * Method that fetches InventoryLibrary according to
	 * 
	 * @param id
	 * @return InventoryLibraryResponseDTO
	 */
	
	InventoryLibraryResponseDTO getInventoryLibraryById(Long id);
	
	/**
	 * Service method that persist InventoryLibrary to the DB
	 * 
	 * @param inventoryLibraryRequestDTO
	 * @return InventoryLibraryResponseDTO
	 */

	InventoryLibraryResponseDTO saveInventoryLibrary(InventoryLibraryRequestDTO inventoryLibraryRequestDTO);
	
	/**
	 * Method that updateInventoryLibrary object in DB
	 * 
	 * @param id
	 * @param inventoryLibraryRequestDTO
	 * @return JobProductKeywordsResponseDTO
	 */

	InventoryLibraryResponseDTO updateInventoryLibrary(Long id, InventoryLibraryRequestDTO inventoryLibraryRequestDTO);
	/**
	 * Fetches InventoryLibrary object list based on a criteria object
	 * 
	 * @param inventoryLibraryRequestDTO
	 * @return List<InventoryLibraryResponseDTO>
	 */

	List<InventoryLibraryResponseDTO> findInventoryLibraryByCriteria(InventoryLibraryRequestDTO inventoryLibraryRequestDTO) throws Exception;
	
	/**
	 * Deletes a InventoryLibrary object from the DB based on id
	 * 
	 * @param id
	 * @return InventoryLibraryResponseDTO
	 */

	InventoryLibraryResponseDTO deleteInventoryLibraryById(Long id);

	
}
