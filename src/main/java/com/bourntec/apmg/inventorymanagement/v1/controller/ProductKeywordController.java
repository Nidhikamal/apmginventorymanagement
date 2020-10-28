package com.bourntec.apmg.inventorymanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.ProductKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.ProductKeywordsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.ProductKeywordService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/productkeyword")
public class ProductKeywordController {

	@Autowired
	ProductKeywordService inventoryService;
	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Inventory
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@PostMapping("/inventory")
	public ResponseEntity<ProductKeywordsResponseDTO> saveinventory(@RequestBody ProductKeywordRequestDTO productKeywordRequestDTO)
			throws Exception {

		ProductKeywordsResponseDTO invRespDTO = inventoryService.saveProductKeywords(productKeywordRequestDTO);

		return ResponseEntity.ok(invRespDTO);

	}
}
