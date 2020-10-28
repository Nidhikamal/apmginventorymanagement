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

import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.entity.InventoryStockHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryStockHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryStockHistoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryRankService;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryStockHistoryService;

/**
 * @author Babu
 *  *
 */
@RestController(value = "InventoryStockHistoryController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invstockhistory")
public class InventoryStockHistoryController {

	@Autowired
	InventoryStockHistoryService inventoryStockHistory;

	/**
	 * @Author:Babu
	 * @param
	 * @return ResponseEntity<InventoryRank>
	 */

	@GetMapping("")
	public ResponseEntity<List<InventoryStockHistory>> fetchInventoryStockHistory() throws Exception {

		List<InventoryStockHistory> allInvRanks = inventoryStockHistory.findAllInventoryStockHistory();
		return ResponseEntity.ok(allInvRanks);
	}

	/**
	 * @Author: Amal 
	 * @param rank
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventoryStockHistoryResponseDTO> fetchByInventoryStockHistory(@PathVariable String id) throws Exception {

		InventoryStockHistoryResponseDTO invResDTO = inventoryStockHistory.findInventoryStockHistoryById(id);

		return ResponseEntity.ok(invResDTO);
	}

	/**
	 * @Author: Babu
	 */

	@PostMapping("")
	public ResponseEntity<InventoryStockHistoryResponseDTO> saveInventoryStockHistory(@RequestBody InventoryStockHistoryRequestDTO invReqDTO)
			throws Exception {

		InventoryStockHistoryResponseDTO invResDTO = inventoryStockHistory.saveInventoryStockHistory(invReqDTO);

		return ResponseEntity.ok(invResDTO);

	}

	/**
	 * @Author: Babu
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventoryStockHistoryResponseDTO> updateInventoryStockHistory(@RequestBody InventoryStockHistoryRequestDTO invReqDTO,
			@PathVariable String id) throws Exception {

		InventoryStockHistoryResponseDTO invResDTO = inventoryStockHistory.updateInventoryStockHistory(id, invReqDTO);
		return ResponseEntity.ok(invResDTO);
	}

	/**
	 @author Babu
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<InventoryStockHistoryResponseDTO> deleteInventoryStockHistory(@PathVariable String id) throws Exception {
		InventoryStockHistoryResponseDTO responsetDTO = inventoryStockHistory.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 @author Babu
	 */

	@PostMapping("/search")
	public ResponseEntity<List<InventoryStockHistory>> searchInventoryStockHistory(
			@RequestBody InventoryStockHistoryRequestDTO shapeRequestDTO) throws Exception {
		List<InventoryStockHistory> responsetDTO = inventoryStockHistory.search(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}