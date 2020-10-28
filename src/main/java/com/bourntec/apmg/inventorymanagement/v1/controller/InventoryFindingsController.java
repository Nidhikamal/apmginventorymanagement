package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryFindingsService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invfindings")
public class InventoryFindingsController {

	@Autowired
	InventoryFindingsService inventoryFindingsService;

	/**
	 * @Author:Srijini AP-130 - > AP-238 Inventory Edit unit of measure finished
	 *                 jewelry -findings
	 * 
	 *                 End point for list all finding of corresponding item
	 * 
	 * @param itemCode
	 * @return ResponseEntity<List<InventoryFindingsResponseDTO>>
	 */
	@GetMapping("/{itemCode}")
	public ResponseEntity<List<InventoryFindingsResponseDTO>> getItemFindings(@PathVariable String itemCode)
			throws Exception {

		List<InventoryFindingsResponseDTO> findingsResponseDTO = inventoryFindingsService.getItemFindings(itemCode);
		return ResponseEntity.ok(findingsResponseDTO);

	}
	/**
	 * @Author:Srijini This REST endpoint for saving findings of item
	 * @param
	 * @return ResponseEntity<List<InventoryFindingsResponseDTO>>
	 */
	@PostMapping("")
	public ResponseEntity<List<InventoryFindingsResponseDTO>> saveFindings(
			@RequestBody List<InventoryFindingsRequestDTO> invReqDTO) throws Exception {

		List<InventoryFindingsResponseDTO> responseDTO = inventoryFindingsService.saveFindings(invReqDTO);
		return ResponseEntity.ok(responseDTO);

	}
}