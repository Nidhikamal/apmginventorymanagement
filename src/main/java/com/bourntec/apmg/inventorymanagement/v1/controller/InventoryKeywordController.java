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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryKeywordService;
/**
 * Controller for InventoryKeyword
 * @author NInce
 *
 */
@RestController(value = "InventoryKeywordController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorykeyword")
public class InventoryKeywordController {

	@Autowired
	InventoryKeywordService inventoryKeywordService;

	/**
	 * This REST end point exposes the search interface for returning all inventory Keyword
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryKeywordResponseDTO>> fetchAllData() throws Exception {

		List<InventoryKeywordResponseDTO> allData = inventoryKeywordService.findAllInventoryKeyword();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning Inventory Keyword
	 * keyword by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventoryKeywordResponseDTO> getInventoryKeywordById(@PathVariable Long id)
			throws Exception {

		InventoryKeywordResponseDTO selectedInventoryKeyword = inventoryKeywordService
				.getInventoryKeywordById(id);

		return ResponseEntity.ok(selectedInventoryKeyword);
	}

	/**
	 * This REST end point for saving InventoryKeyword
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InventoryKeywordResponseDTO> saveInventoryKeyword(
			@RequestBody InventoryKeywordRequestDTO inventoryKeywordReq) throws Exception {

		InventoryKeywordResponseDTO savedrespData = inventoryKeywordService.saveInventoryKeyword(inventoryKeywordReq);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST end point for updating InventoryKeyword by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventoryKeywordResponseDTO> updateInventoryKeyword(
			@RequestBody InventoryKeywordRequestDTO inventoryKeywordReq, @PathVariable Long id) throws Exception {

		InventoryKeywordResponseDTO updatedrespData = inventoryKeywordService.updateInventoryKeyword(id,
				inventoryKeywordReq);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST end point exposes the search interface for searching
	 * InventoryKeyword
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryKeywordResponseDTO>> findInventoryKeywordByCriteria(
			@RequestBody InventoryKeywordRequestDTO inventoryKeywordReq) throws Exception {

		List<InventoryKeywordResponseDTO> selectedInventoryKeyword = inventoryKeywordService
				.findInventoryKeywordByCriteria(inventoryKeywordReq);

		return ResponseEntity.ok(selectedInventoryKeyword);
	}

	/**
	 * This REST endpoint exposes the delete InventoryKeyword by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryKeywordResponseDTO> deleteInventoryKeywordById(@PathVariable("id") Long id) {
		InventoryKeywordResponseDTO inventoryKeywordResponseDTO = inventoryKeywordService
				.deleteInventoryKeywordById(id);
		return ResponseEntity.ok(inventoryKeywordResponseDTO);
	}
}
