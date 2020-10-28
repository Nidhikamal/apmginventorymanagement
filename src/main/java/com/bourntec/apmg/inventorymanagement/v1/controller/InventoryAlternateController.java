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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryAlternateRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryAlternateResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryAlternateService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventoryalternate")
public class InventoryAlternateController {

	@Autowired
	InventoryAlternateService invAlternateService;
	/**
	 * This API saves a Memo Manifest
	 * 
	 * @param MemoManifestRequestDTO
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<InventoryAlternateResponseDTO> saveInventoryAlternate(
			@RequestBody InventoryAlternateRequestDTO inventoryAlternateRequestdto) throws Exception {
		InventoryAlternateResponseDTO manifestResponsedto = invAlternateService.saveInventoryAlternate(inventoryAlternateRequestdto);
		return ResponseEntity.ok(manifestResponsedto);
	}

	/**
	 * This API updates a Inventory Alternate
	 * 
	 * @param id
	 * @param InventoryAlternateRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<InventoryAlternateResponseDTO> updateInventoryAlternate(@PathVariable Long id,
			@RequestBody InventoryAlternateRequestDTO inventoryAlternateRequestdto) throws Exception {
		InventoryAlternateResponseDTO inventoryAlternateResponsedto = invAlternateService
				.updateInventoryAlternate(id, inventoryAlternateRequestdto);
		return ResponseEntity.ok(inventoryAlternateResponsedto);
	}

	/**
	 * This API fetches Inventory Alternate according to {id}
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{id}")
	public ResponseEntity<InventoryAlternateResponseDTO> getById(@PathVariable Long id)
			throws Exception {
		InventoryAlternateResponseDTO inventoryAlternateResponsedto = invAlternateService.getById(id);
		return ResponseEntity.ok(inventoryAlternateResponsedto);
	}

	/**
	 * This API fetches all Inventory Alternates.
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryAlternateResponseDTO>> getAll() throws Exception {
		List<InventoryAlternateResponseDTO> inventoryAlternateResponseList = invAlternateService.getAll();
		return ResponseEntity.ok(inventoryAlternateResponseList);
	}

	/**
	 * REST endpoint exposes the search interface for searching a Inventory Alternate
	 * dynamically
	 * 
	 * @param InventoryAlternateRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryAlternateResponseDTO>> fetchByInventoryAlternate(
			@RequestBody InventoryAlternateRequestDTO inventoryAlternateRequestdto) throws Exception {

		List<InventoryAlternateResponseDTO> inventoryAlternateResponseList = invAlternateService.fetchByInventoryAlternate(inventoryAlternateRequestdto);

		return ResponseEntity.ok(inventoryAlternateResponseList);
	}

	/**
	 * This API delete a Inventory Alternate
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<InventoryAlternateResponseDTO> deleteInventoryAlternate(@PathVariable Long id) {
		InventoryAlternateResponseDTO inventoryAlternateResponse = invAlternateService.deleteInventoryAlternate(id);
		return ResponseEntity.ok(inventoryAlternateResponse);
	}
}
