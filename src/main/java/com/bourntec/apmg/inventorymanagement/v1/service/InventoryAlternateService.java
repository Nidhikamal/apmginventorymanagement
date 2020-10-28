package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryAlternateRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryAlternateResponseDTO;

public interface InventoryAlternateService {

	/**
	 * Service method that persist Inventory Alternate to the DB
	 * 
	 * @param inventoryAlternateRequestDTO
	 * @return
	 */
	InventoryAlternateResponseDTO saveInventoryAlternate(InventoryAlternateRequestDTO inventoryAlternateRequestDTO);
	
	/**
	 * Method that updates Inventory Alternate object in DB
	 * 
	 * @param id
	 * @param inventoryAlternateDTO
	 * @return
	 */
	InventoryAlternateResponseDTO updateInventoryAlternate(Long id,
			InventoryAlternateRequestDTO inventoryAlternateRequestDTO);
	/**
	 * Method that fetches Inventory Alternate according to
	 * 
	 * @param id
	 * @return
	 */
	InventoryAlternateResponseDTO getById(Long id);
	/**
	 * Handles the fetching of all the Inventory Alternate in DB
	 * 
	 * @return
	 */
	List<InventoryAlternateResponseDTO> getAll();
	
	/**
	 * Fetches a Inventory Alternate object based on a criteria object
	 * 
	 * @param InventoryAlternateRequestDTO
	 * @return
	 */
	List<InventoryAlternateResponseDTO> fetchByInventoryAlternate(InventoryAlternateRequestDTO manifestRequestDTO) throws Exception;
	/**
	 * Deletes a Inventory Alternate object from the DB based on
	 * 
	 * @param id
	 * @return 
	 */
	InventoryAlternateResponseDTO deleteInventoryAlternate(Long id);

}
