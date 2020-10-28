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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryMarketRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryMarketResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryMarketService;
/**
 * Controller for InventoryMarket
 * @author NInce
 *
 */
@RestController(value = "InventoryMarketController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorymarket")
public class InventoryMarketController {

	@Autowired
	InventoryMarketService inventoryMarketService;

	/**
	 * This REST end point exposes the search interface for returning all inventory Market
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryMarketResponseDTO>> fetchAllData() throws Exception {

		List<InventoryMarketResponseDTO> allData = inventoryMarketService.findAllInventoryMarket();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning Inventory Market
	 * Market by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventoryMarketResponseDTO> getInventoryMarketById(@PathVariable Long id)
			throws Exception {

		InventoryMarketResponseDTO selectedInventoryMarket = inventoryMarketService
				.getInventoryMarketById(id);

		return ResponseEntity.ok(selectedInventoryMarket);
	}

	/**
	 * This REST end point for saving InventoryMarket
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InventoryMarketResponseDTO> saveInventoryMarket(
			@RequestBody InventoryMarketRequestDTO inventoryMarketReq) throws Exception {

		InventoryMarketResponseDTO savedrespData = inventoryMarketService.saveInventoryMarket(inventoryMarketReq);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST end point for updating InventoryMarket by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventoryMarketResponseDTO> updateInventoryMarket(
			@RequestBody InventoryMarketRequestDTO inventoryMarketReq, @PathVariable Long id) throws Exception {

		InventoryMarketResponseDTO updatedrespData = inventoryMarketService.updateInventoryMarket(id,
				inventoryMarketReq);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST end point exposes the search interface for searching
	 * InventoryMarket
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryMarketResponseDTO>> findInventoryMarketByCriteria(
			@RequestBody InventoryMarketRequestDTO inventoryMarketReq) throws Exception {

		List<InventoryMarketResponseDTO> selectedInventoryMarket = inventoryMarketService
				.findInventoryMarketByCriteria(inventoryMarketReq);

		return ResponseEntity.ok(selectedInventoryMarket);
	}

	/**
	 * This REST endpoint exposes the delete InventoryMarket by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryMarketResponseDTO> deleteInventoryMarketById(@PathVariable("id") Long id) {
		InventoryMarketResponseDTO inventoryMarketResponseDTO = inventoryMarketService
				.deleteInventoryMarketById(id);
		return ResponseEntity.ok(inventoryMarketResponseDTO);
	}
}
