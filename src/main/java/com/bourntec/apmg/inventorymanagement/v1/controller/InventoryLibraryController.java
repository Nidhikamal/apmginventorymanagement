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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryService;


/**
 *  Controller for InventoryLibrary Refactoring
 * 
 * @author Vidya
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorylibrary")
public class InventoryLibraryController {


	@Autowired
	InventoryLibraryService  inventoryLibraryService;

	/**
	 * This REST endpoint exposes the search interface for returning all Inventory Weight
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryLibraryResponseDTO>> fetchAllData() throws Exception {

		List<InventoryLibraryResponseDTO> allData = inventoryLibraryService.findAllInventoryLibrary();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning Inventory Weight
	 *  by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventoryLibraryResponseDTO> getInventoryLibraryById(@PathVariable Long id)
			throws Exception {

		InventoryLibraryResponseDTO selectedInventoryLibrary = inventoryLibraryService
				.getInventoryLibraryById(id);

		return ResponseEntity.ok(selectedInventoryLibrary);
	}

	/**
	 * This REST endpoint for saving Inventory Weight
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InventoryLibraryResponseDTO> saveInventoryLibrary(
			@RequestBody InventoryLibraryRequestDTO inventoryLibraryRequestDTO) throws Exception {

		InventoryLibraryResponseDTO savedrespData = inventoryLibraryService.saveInventoryLibrary(inventoryLibraryRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST endpoint for updating Inventory Weight by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventoryLibraryResponseDTO> updateInventoryLibrary(
			@RequestBody InventoryLibraryRequestDTO inventoryLibraryRequestDTO, @PathVariable Long id) throws Exception {

		InventoryLibraryResponseDTO updatedrespData = inventoryLibraryService.updateInventoryLibrary(id,
				inventoryLibraryRequestDTO);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST endpoint exposes the search interface for searching
	 * Inventory Weight
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryLibraryResponseDTO>> findInventoryLibraryByCriteria(
			@RequestBody InventoryLibraryRequestDTO inventoryLibraryRequestDTO) throws Exception {

		List<InventoryLibraryResponseDTO> selectedInventoryLibraryResponseDTO = inventoryLibraryService
				.findInventoryLibraryByCriteria(inventoryLibraryRequestDTO);

		return ResponseEntity.ok(selectedInventoryLibraryResponseDTO);
	}

	/**
	 * This REST endpoint exposes the delete Inventory Weight by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryLibraryResponseDTO> deleteInventoryLibraryById(@PathVariable("id") Long id) {
		InventoryLibraryResponseDTO invWeightResponseDTO = inventoryLibraryService
				.deleteInventoryLibraryById(id);
		return ResponseEntity.ok(invWeightResponseDTO);
	}
}
