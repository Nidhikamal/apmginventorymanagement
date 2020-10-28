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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryMaterialRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryMaterialResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryMaterialService;


/**
 *  Controller for InventoryLibraryMaterial Refactoring
 * 
 * @author Vidya
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorylibrarymaterial")
public class InventoryLibraryMaterialController {


	@Autowired
	InventoryLibraryMaterialService  inventoryLibraryMaterialService;

	/**
	 * This REST endpoint exposes the search interface for returning all InventoryLibraryMaterial Finding
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryLibraryMaterialResponseDTO>> fetchAllData() throws Exception {

		List<InventoryLibraryMaterialResponseDTO> allData = inventoryLibraryMaterialService.findAllInventoryLibraryMaterial();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning InventoryLibraryMaterial Finding
	 *  by id
	 * 
	 */

	@GetMapping("/{id}")
	public ResponseEntity<InventoryLibraryMaterialResponseDTO> getInventoryLibraryMaterialById(@PathVariable Long id)
			throws Exception {

		InventoryLibraryMaterialResponseDTO selectedInventoryLibraryMaterial = inventoryLibraryMaterialService
				.getInventoryLibraryMaterialById(id);

		return ResponseEntity.ok(selectedInventoryLibraryMaterial);
	}

	/**
	 * This REST endpoint for saving InventoryLibraryMaterial Finding
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InventoryLibraryMaterialResponseDTO> saveInventoryLibraryMaterial(
			@RequestBody InventoryLibraryMaterialRequestDTO inventoryLibraryRequestDTO) throws Exception {

		InventoryLibraryMaterialResponseDTO savedrespData = inventoryLibraryMaterialService.saveInventoryLibraryMaterial(inventoryLibraryRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST endpoint for updating InventoryLibraryMaterial Finding by Id
	 * 
	 */

	@PutMapping("/{id}")
	public ResponseEntity<InventoryLibraryMaterialResponseDTO> updateInventoryLibraryMaterial(
			@RequestBody InventoryLibraryMaterialRequestDTO inventoryLibraryRequestDTO, @PathVariable Long id) throws Exception {

		InventoryLibraryMaterialResponseDTO updatedrespData = inventoryLibraryMaterialService.updateInventoryLibraryMaterial(id,
				inventoryLibraryRequestDTO);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST endpoint exposes the search interface for searching
	 * InventoryLibraryMaterial Finding
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryLibraryMaterialResponseDTO>> findInventoryLibraryMaterialByCriteria(
			@RequestBody InventoryLibraryMaterialRequestDTO inventoryLibraryRequestDTO) throws Exception {

		List<InventoryLibraryMaterialResponseDTO> selectedInventoryLibraryMaterialResponseDTO = inventoryLibraryMaterialService
				.findInventoryLibraryMaterialByCriteria(inventoryLibraryRequestDTO);

		return ResponseEntity.ok(selectedInventoryLibraryMaterialResponseDTO);
	}

	/**
	 * This REST endpoint exposes the delete InventoryLibraryMaterial Finding by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryLibraryMaterialResponseDTO> deleteInventoryLibraryMaterialById(@PathVariable("id") Long id) {
		InventoryLibraryMaterialResponseDTO inventoryLibraryFindingResponseDTO = inventoryLibraryMaterialService
				.deleteInventoryLibraryMaterialById(id);
		return ResponseEntity.ok(inventoryLibraryFindingResponseDTO);
	}
}
