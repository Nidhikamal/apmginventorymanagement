package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomManfStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CustomManfStonService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/custommanfstone")
public class CustomManfStoneController {
	
	@Autowired
	CustomManfStonService customManfStonService;
	/**
	 * @Author:Srijini AP-130 - > AP-239 Inventory Edit unit of measure finished
	 *                 jewelry - Stones
	 * 
	 *                 End point for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<List<CustomManfStoneResponseDTO>>
	 */
	@GetMapping("/{itemCode}")
	public ResponseEntity<List<CustomManfStoneResponseDTO>> getItemStones(@PathVariable String itemCode)
			throws Exception {

		List<CustomManfStoneResponseDTO> manfStoneResponseDTOs = customManfStonService.getItemStones(itemCode);
		return ResponseEntity.ok(manfStoneResponseDTOs);

	}
}
