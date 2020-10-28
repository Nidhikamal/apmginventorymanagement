package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory2RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory2ResponseDTO;

public interface Inventory2Service {
	/**
	 * Service method that persist Inventory2 to the DB
	 * 
	 * @param inventory2RequestDTO
	 * @return
	 */
	Inventory2ResponseDTO saveInventory2(Inventory2RequestDTO inventory2RequestDTO);
	
	/**
	 * Method that updates Inventory2 object in DB
	 * 
	 * @param itemCode
	 * @param inventory2RequestDTO
	 * @return
	 */
	Inventory2ResponseDTO updateInventory2(String itemCode,
			Inventory2RequestDTO inventory2RequestDTO);
	/**
	 * Method that fetches Inventory2 according to
	 * 
	 * @param itemCode
	 * @return
	 */
	Inventory2ResponseDTO getById(String itemCode);
	/**
	 * Handles the fetching of all the Inventory2 in DB
	 * 
	 * @return
	 */
	List<Inventory2ResponseDTO> getAll();
	
	/**
	 * Fetches a Inventory2 object based on a criteria object
	 * 
	 * @param inventory2RequestDTO
	 * @return
	 */
	List<Inventory2ResponseDTO> fetchByInventory2(Inventory2RequestDTO inventory2RequestDTO) throws Exception;
	/**
	 * Deletes a Inventory2 object from the DB based on
	 * 
	 * @param itemCode
	 * @return 
	 */
	Inventory2ResponseDTO deleteInventory2(String itemCode);
}
