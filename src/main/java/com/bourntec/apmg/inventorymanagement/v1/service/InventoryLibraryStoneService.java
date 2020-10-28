package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryStoneResponseDTO;
/**
 * Service interface for InventoryLibraryStone
 * @author AMAL
 *
 */
public interface InventoryLibraryStoneService {
	/**
	 * Method that fetches InventoryLibraryStoneService.java according to
	 * @param id
	 * @return InventoryLibraryStoneService.javaResponseDTO
	 */
	InventoryLibraryStoneResponseDTO getInventoryLibraryStoneById(Long id);
	/**
	 * Handles fetching of all the InventoryLibraryStone from DB
	 * @return InventoryLibraryStoneResponseDTO
	 */
	List<InventoryLibraryStoneResponseDTO> findAllInventoryLibraryStones();
	/**
	 * Service method that persist InventoryLibraryStone to the DB
	 * @param InventoryLibraryStoneRequestDTO
	 * @return InventoryLibraryStoneResponseDTO
	 */
	InventoryLibraryStoneResponseDTO saveInventoryLibraryStone(InventoryLibraryStoneRequestDTO dataReq);
	/**
	 * Method that updatesInventoryLibraryStone object in DB
	 * @param id
	 * @param InventoryLibraryStoneRequestDTO
	 * @return InventoryLibraryStoneResponseDTO
	 */
	InventoryLibraryStoneResponseDTO updateInventoryLibraryStone(Long id, InventoryLibraryStoneRequestDTO dataReq);
	/**
	 * Fetches InventoryLibraryStone object list based on a criteria object
	 * @param InventoryLibraryStoneRequestDTO
	 * @return List<InventoryLibraryStoneResponseDTO>
	 */
	List<InventoryLibraryStoneResponseDTO> findInventoryLibraryStoneByCriteria(InventoryLibraryStoneRequestDTO dataReq) throws Exception;
	/**
	 * Deletes a InventoryLibraryStone object from the DB based on id
	 * @param id
	 * @return InventoryLibraryStoneResponseDTO
	 */
	InventoryLibraryStoneResponseDTO deleteInventoryLibraryStoneById(Long id);
}
