package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySummaryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventorySummaryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryFindingsService;
import com.bourntec.apmg.inventorymanagement.v1.service.InventorySummaryService;

/**
 *  - Inventory Summary
 * 
 * @author Babu
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invsummary")
public class InventorySummaryController {

	@Autowired
	InventorySummaryService inventorySummaryService;

	/**
	 *@author Babu
	 * @param itemCode
	 * @return ResponseEntity<List<InventoryFindingsResponseDTO>>
	 */
	@GetMapping("/{itemCode}")
	public ResponseEntity<InventorySummaryResponseDTO> getItemSummary(@PathVariable String itemCode)
			throws Exception {

		InventorySummaryResponseDTO summaryResponseDTO = inventorySummaryService.getItemSummary(itemCode);
		return ResponseEntity.ok(summaryResponseDTO);

	}
	/**
	 * @Author:Babu
	 * @param
	 * @return ResponseEntity<List<InventoryFindingsResponseDTO>>
	 */
	@PostMapping("")
	public ResponseEntity<InventorySummaryResponseDTO> saveSummary(
			@RequestBody InventorySummaryRequestDTO invReqDTO) throws Exception {

		InventorySummaryResponseDTO responseDTO = inventorySummaryService.saveSummary(invReqDTO);
		return ResponseEntity.ok(responseDTO);

	}
	@PutMapping("")
	public ResponseEntity<InventorySummaryResponseDTO> updateSummary(
			@RequestBody InventorySummaryRequestDTO invReqDTO,@RequestParam String itemCode) throws Exception {

		InventorySummaryResponseDTO responseDTO = inventorySummaryService.updateSummary(invReqDTO,itemCode);
		return ResponseEntity.ok(responseDTO);

	}
}