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
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.entity.VendorItemMatch;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.VendorItemMatchRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.VendorItemMatchResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.VendorItemMatchService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/vendoritem")
public class VendorItemController {

	@Autowired
	VendorItemMatchService vendorItemService;

	/**
	 * @Author: Babu This REST endpoint exposes the search interface for saving
	 *          Inventory
	 * @param VendorItemMatchRequestDTO
	 * @return ResponseEntity<VendorItemMatchResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<VendorItemMatchResponseDTO> saveinventory(
			@RequestBody List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO) throws Exception {

		VendorItemMatchResponseDTO invRespDTO = vendorItemService.saveInvetoryData(lstvendorItemMatchRequestDTO);

		return ResponseEntity.ok(invRespDTO);

	}
	@PutMapping("/{itemCode}")
	public ResponseEntity<VendorItemMatchResponseDTO> updateVendorItemMatch(
			@RequestBody List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO,@PathVariable String itemCode) throws Exception {

		VendorItemMatchResponseDTO invRespDTO = vendorItemService.updateVendorItemMatch(lstvendorItemMatchRequestDTO,itemCode);

		return ResponseEntity.ok(invRespDTO);

	}
	@GetMapping("/{itemCode}")
	public ResponseEntity<List<VendorItemMatch>> fetchAllVendorItemMatch(@PathVariable String itemCode) throws Exception {

		List<VendorItemMatch> allKeywords = vendorItemService.fetchAllVendorItemMatchByItemcode(itemCode);
		return ResponseEntity.ok(allKeywords);
	}
}