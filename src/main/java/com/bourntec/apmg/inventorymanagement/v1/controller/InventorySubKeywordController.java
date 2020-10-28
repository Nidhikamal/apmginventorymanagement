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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventorySubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventorySubKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventorySubKeywordService;
/**
 * Controller for InventorySubKeyword
 * @author NInce
 *
 */
@RestController(value = "InventorySubKeywordController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/Inventorysubkeyword")
public class InventorySubKeywordController {

	@Autowired
	InventorySubKeywordService inventorySubKeywordService;

	/**
	 * This REST end point exposes the search interface for returning all inventory Sub Keyword
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventorySubKeywordResponseDTO>> fetchAllData() throws Exception {

		List<InventorySubKeywordResponseDTO> allData = inventorySubKeywordService.findAllInventorySubKeyword();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning Inventory Keyword
	 * keyword by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventorySubKeywordResponseDTO> getInventorySubKeywordById(@PathVariable Long id)
			throws Exception {

		InventorySubKeywordResponseDTO selectedInventorySubKeyword = inventorySubKeywordService
				.getInventorySubKeywordById(id);

		return ResponseEntity.ok(selectedInventorySubKeyword);
	}

	/**
	 * This REST end point for saving InventorySubKeyword
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InventorySubKeywordResponseDTO> saveInventorySubKeyword(
			@RequestBody InventorySubKeywordRequestDTO InventorySubKeywordReq) throws Exception {

		InventorySubKeywordResponseDTO savedrespData = inventorySubKeywordService.saveInventorySubKeyword(InventorySubKeywordReq);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST end point for updating InventorySubKeyword by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventorySubKeywordResponseDTO> updateInventorySubKeyword(
			@RequestBody InventorySubKeywordRequestDTO InventorySubKeywordReq, @PathVariable Long id) throws Exception {

		InventorySubKeywordResponseDTO updatedrespData = inventorySubKeywordService.updateInventorySubKeyword(id,
				InventorySubKeywordReq);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST end point exposes the search interface for searching
	 * InventorySubKeyword
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventorySubKeywordResponseDTO>> findInventorySubKeywordByCriteria(
			@RequestBody InventorySubKeywordRequestDTO InventorySubKeywordReq) throws Exception {

		List<InventorySubKeywordResponseDTO> selectedInventorySubKeyword = inventorySubKeywordService
				.findInventorySubKeywordByCriteria(InventorySubKeywordReq);

		return ResponseEntity.ok(selectedInventorySubKeyword);
	}

	/**
	 * This REST endpoint exposes the delete InventorySubKeyword by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventorySubKeywordResponseDTO> deleteInventorySubKeywordById(@PathVariable("id") Long id) {
		InventorySubKeywordResponseDTO InventorySubKeywordResponseDTO = inventorySubKeywordService
				.deleteInventorySubKeywordById(id);
		return ResponseEntity.ok(InventorySubKeywordResponseDTO);
	}
}
