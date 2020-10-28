package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibrarySmallStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibrarySmallStoneResponseDTO;
/**
 * Service interface for InventoryLibrarySmallStone
 * @author AMAL
 *
 */
public interface InventoryLibrarySmallStoneService {
	/**
	 * Method that fetches InventoryLibrarySmallStone according to
	 * @param id
	 * @return InventoryLibrarySmallStoneResponseDTO
	 */
	InventoryLibrarySmallStoneResponseDTO getInventoryLibrarySmallStoneById(Long id);
	/**
	 * Handles fetching of all the InventoryLibrarySmallStone from DB
	 * @return InventoryLibrarySmallStoneResponseDTO
	 */
	List<InventoryLibrarySmallStoneResponseDTO> findAllInventoryLibrarySmallStones();
	/**
	 * Service method that persist InventoryLibrarySmallStone to the DB
	 * @param InventoryLibrarySmallStoneRequestDTO
	 * @return InventoryLibrarySmallStoneResponseDTO
	 */
	InventoryLibrarySmallStoneResponseDTO saveInventoryLibrarySmallStone(InventoryLibrarySmallStoneRequestDTO dataReq);
	/**
	 * Method that updatesInventoryLibrarySmallStone object in DB
	 * @param id
	 * @param InventoryLibrarySmallStoneRequestDTO
	 * @return InventoryLibrarySmallStoneResponseDTO
	 */
	InventoryLibrarySmallStoneResponseDTO updateInventoryLibrarySmallStone(Long id, InventoryLibrarySmallStoneRequestDTO dataReq);
	/**
	 * Fetches InventoryLibrarySmallStone object list based on a criteria object
	 * @param InventoryLibrarySmallStoneRequestDTO
	 * @return List<InventoryLibrarySmallStoneResponseDTO>
	 */
	List<InventoryLibrarySmallStoneResponseDTO> findInventoryLibrarySmallStoneByCriteria(InventoryLibrarySmallStoneRequestDTO dataReq) throws Exception;
	/**
	 * Deletes a InventoryLibrarySmallStone object from the DB based on id
	 * @param id
	 * @return InventoryLibrarySmallStoneResponseDTO
	 */
	InventoryLibrarySmallStoneResponseDTO deleteInventoryLibrarySmallStoneById(Long id);
}
