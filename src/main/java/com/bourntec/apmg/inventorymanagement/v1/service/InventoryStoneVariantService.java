package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryStoneVariantRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryStoneVariantResponseDTO;
/**
 * Service interface for InventoryStoneVariant
 * @author AMAL
 *
 */
public interface InventoryStoneVariantService {
	/**
	 * Method that fetches InventoryStoneVariantService according to
	 * @param id
	 * @return InventoryStoneVariantService.javaResponseDTO
	 */
	InventoryStoneVariantResponseDTO getInventoryStoneVariantById(Long id);
	/**
	 * Handles fetching of all the InventoryStoneVariant from DB
	 * @return InventoryStoneVariantResponseDTO
	 */
	List<InventoryStoneVariantResponseDTO> findAllInventoryStoneVariants();
	/**
	 * Service method that persist InventoryStoneVariant to the DB
	 * @param InventoryStoneVariantRequestDTO
	 * @return InventoryStoneVariantResponseDTO
	 */
	InventoryStoneVariantResponseDTO saveInventoryStoneVariant(InventoryStoneVariantRequestDTO dataReq);
	/**
	 * Method that updatesInventoryStoneVariant object in DB
	 * @param id
	 * @param InventoryStoneVariantRequestDTO
	 * @return InventoryStoneVariantResponseDTO
	 */
	InventoryStoneVariantResponseDTO updateInventoryStoneVariant(Long id, InventoryStoneVariantRequestDTO dataReq);
	/**
	 * Fetches InventoryStoneVariant object list based on a criteria object
	 * @param InventoryStoneVariantRequestDTO
	 * @return List<InventoryStoneVariantResponseDTO>
	 */
	List<InventoryStoneVariantResponseDTO> findInventoryStoneVariantByCriteria(InventoryStoneVariantRequestDTO dataReq) throws Exception;
	/**
	 * Deletes a InventoryStoneVariant object from the DB based on id
	 * @param id
	 * @return InventoryStoneVariantResponseDTO
	 */
	InventoryStoneVariantResponseDTO deleteInventoryStoneVariantById(Long id);
}
