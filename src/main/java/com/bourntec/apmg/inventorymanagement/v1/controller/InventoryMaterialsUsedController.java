package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.InventoryMaterialsUsed;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMaterialsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryMaterialsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryMaterialsUsedService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invmaterialused")
public class InventoryMaterialsUsedController {

	@Autowired
	InventoryMaterialsUsedService inventoryService;
	
	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Inventory material
	 * @param
	 * @return ResponseEntity<List<InventoryMaterialsResponseDTO>>
	 */

	@PostMapping("")
	public ResponseEntity<InventoryMaterialsResponseDTO> saveinventory(@RequestBody List<InventoryMaterialsRequestDTO> invReqDTO)
			throws Exception {

		InventoryMaterialsResponseDTO invRespDTO = inventoryService.saveMamaterial(invReqDTO);

		return ResponseEntity.ok(invRespDTO);

	}
	@PutMapping("/{itemCode}")
	public ResponseEntity<InventoryMaterialsResponseDTO> updateInventoryMaterials(
			@RequestBody List<InventoryMaterialsRequestDTO> lstinventoryMaterialsRequestDTO,@PathVariable String itemCode) throws Exception {

		InventoryMaterialsResponseDTO invRespDTO = inventoryService.updateInventoryMaterials(lstinventoryMaterialsRequestDTO,itemCode);

		return ResponseEntity.ok(invRespDTO);

	}
	@GetMapping("/{itemCode}")
	public ResponseEntity<List<InventoryMaterialsUsed>> fetchAllInventoryMaterialsUsed(@PathVariable String itemCode) throws Exception {

		List<InventoryMaterialsUsed> allKeywords = inventoryService.fetchAllInventoryMaterialsUsedByItemcode(itemCode);
		return ResponseEntity.ok(allKeywords);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<InventoryMaterialsResponseDTO> deleteInventoryMaterialsUsed(@PathVariable Long id) throws Exception {
		InventoryMaterialsResponseDTO responsetDTO = inventoryService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

}
