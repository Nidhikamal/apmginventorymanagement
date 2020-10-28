package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.InventoryPriceHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryPriceHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryPriceHistoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryPriceHistoryService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/pricehistory")
public class InventoryPriceHistoryController {

	@Autowired
	InventoryPriceHistoryService inventoryService;

	/**
	 * 
	 * @param invReqDTO
	 * @return InventoryPriceHistoryResponseDTO
	 * @throws Exception
	 */
	@PutMapping("/inventory/updateprice")
	public ResponseEntity<InventoryPriceHistoryResponseDTO> saveInventoryPrice(
			@RequestBody InventoryPriceHistoryRequestDTO invReqDTO) throws Exception {

		InventoryPriceHistoryResponseDTO inv1ResDTO = inventoryService.saveInvetoryPrice(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	@GetMapping("/inventory/getpricehostory/{itemCode}")
	public ResponseEntity<List<InventoryPriceHistory>> getInventoryPriceHistory(@PathVariable String itemCode)
			throws Exception {

		List<InventoryPriceHistory> priceHistoryList = inventoryService.getAllPriceHistoryofItem(itemCode);
		return ResponseEntity.ok(priceHistoryList);
	}

}
