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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryFindingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryFindingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryFindingService;


/**
 *  Controller for InventoryLibraryFinding Refactoring
 * 
 * @author Vidya
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorylibraryfinding")
public class InventoryLibraryFindingController {


	@Autowired
	InventoryLibraryFindingService  inventoryLibraryFindingService;

	/**
	 * This REST endpoint exposes the search interface for returning all InventoryLibraryFinding Finding
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryLibraryFindingResponseDTO>> fetchAllData() throws Exception {

		List<InventoryLibraryFindingResponseDTO> allData = inventoryLibraryFindingService.findAllInventoryLibraryFinding();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning InventoryLibraryFinding Finding
	 *  by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventoryLibraryFindingResponseDTO> getInventoryLibraryFindingById(@PathVariable Long id)
			throws Exception {

		InventoryLibraryFindingResponseDTO selectedInventoryLibraryFinding = inventoryLibraryFindingService
				.getInventoryLibraryFindingById(id);

		return ResponseEntity.ok(selectedInventoryLibraryFinding);
	}

	/**
	 * This REST endpoint for saving InventoryLibraryFinding Finding
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InventoryLibraryFindingResponseDTO> saveInventoryLibraryFinding(
			@RequestBody InventoryLibraryFindingRequestDTO inventoryLibraryRequestDTO) throws Exception {

		InventoryLibraryFindingResponseDTO savedrespData = inventoryLibraryFindingService.saveInventoryLibraryFinding(inventoryLibraryRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST endpoint for updating InventoryLibraryFinding Finding by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventoryLibraryFindingResponseDTO> updateInventoryLibraryFinding(
			@RequestBody InventoryLibraryFindingRequestDTO inventoryLibraryRequestDTO, @PathVariable Long id) throws Exception {

		InventoryLibraryFindingResponseDTO updatedrespData = inventoryLibraryFindingService.updateInventoryLibraryFinding(id,
				inventoryLibraryRequestDTO);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST endpoint exposes the search interface for searching
	 * InventoryLibraryFinding Finding
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryLibraryFindingResponseDTO>> findInventoryLibraryFindingByCriteria(
			@RequestBody InventoryLibraryFindingRequestDTO inventoryLibraryRequestDTO) throws Exception {

		List<InventoryLibraryFindingResponseDTO> selectedInventoryLibraryFindingResponseDTO = inventoryLibraryFindingService
				.findInventoryLibraryFindingByCriteria(inventoryLibraryRequestDTO);

		return ResponseEntity.ok(selectedInventoryLibraryFindingResponseDTO);
	}

	/**
	 * This REST endpoint exposes the delete InventoryLibraryFinding Finding by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryLibraryFindingResponseDTO> deleteInventoryLibraryFindingById(@PathVariable("id") Long id) {
		InventoryLibraryFindingResponseDTO inventoryLibraryFindingResponseDTO = inventoryLibraryFindingService
				.deleteInventoryLibraryFindingById(id);
		return ResponseEntity.ok(inventoryLibraryFindingResponseDTO);
	}
}
