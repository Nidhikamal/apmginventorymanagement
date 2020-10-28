package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryMaterialRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryMaterialResponseDTO;
/**
 * Service interface for InventoryLibraryMaterialService
 * @author Vidya.p
 *
 */

public interface InventoryLibraryMaterialService {
	
	/**
	 * Handles fetching of all the InventoryLibraryMaterial Finding from DB
	 * 
	 * @return InventoryLibraryMaterialResponseDTO
	 */


	List<InventoryLibraryMaterialResponseDTO> findAllInventoryLibraryMaterial();
	/**
	 * Method that fetches InventoryLibraryMaterial Finding according to
	 * 
	 * @param id
	 * @return InventoryLibraryMaterialResponseDTO
	 */
	
	InventoryLibraryMaterialResponseDTO getInventoryLibraryMaterialById(Long id);
	
	/**
	 * Service method that persist InventoryLibraryMaterial Finding to the DB
	 * 
	 * @param inventoryLibraryMaterialRequestDTO
	 * @return InventoryLibraryMaterialResponseDTO
	 */

	InventoryLibraryMaterialResponseDTO saveInventoryLibraryMaterial(InventoryLibraryMaterialRequestDTO inventoryLibraryMaterialRequestDTO);
	
	/**
	 * Method that updateInventoryLibraryMaterial object in DB
	 * 
	 * @param id
	 * @param inventoryLibraryMaterialRequestDTO
	 * @return inventoryLibraryMaterialFindingResponseDTO
	 */

	InventoryLibraryMaterialResponseDTO updateInventoryLibraryMaterial(Long id, InventoryLibraryMaterialRequestDTO inventoryLibraryMaterialRequestDTO);
	/**
	 * Fetches InventoryLibraryMaterial Finding object list based on a criteria object
	 * 
	 * @param inventoryLibraryMaterialRequestDTO
	 * @return List<InventoryLibraryMaterialResponseDTO>
	 */

	List<InventoryLibraryMaterialResponseDTO> findInventoryLibraryMaterialByCriteria(InventoryLibraryMaterialRequestDTO inventoryLibraryMaterialRequestDTO) throws Exception;
	
	/**
	 * Deletes a InventoryLibraryMaterial Finding object from the DB based on id
	 * 
	 * @param id
	 * @return InventoryLibraryMaterialResponseDTO
	 */

	InventoryLibraryMaterialResponseDTO deleteInventoryLibraryMaterialById(Long id);

	
}
