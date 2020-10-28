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
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibraryStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibraryStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibraryStoneService;
/**
 * Controller for InventoryLibraryStone
 * @author AMAL
 *
 */
@RestController(value = "InventoryLibraryStoneController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorylibrarystone")
public class InventoryLibraryStoneController {
	@Autowired
	InventoryLibraryStoneService invLibStoneService;
	/**
	 * This REST endpoint exposes the search interface for returning all Inventory Library   Stones
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryLibraryStoneResponseDTO>> fetchAllData() throws Exception {

		List<InventoryLibraryStoneResponseDTO> allData = invLibStoneService.findAllInventoryLibraryStones();
		return ResponseEntity.ok(allData);
	}
	/**
	 * This REST endpoint exposes the search interface for returning  Inventory Library   Stones
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<InventoryLibraryStoneResponseDTO> getInventoryLibraryStoneById(@PathVariable Long id)
			throws Exception {

		InventoryLibraryStoneResponseDTO selectedInventoryLibraryStone = invLibStoneService
				.getInventoryLibraryStoneById(id);

		return ResponseEntity.ok(selectedInventoryLibraryStone);
	}
	/**
	 * This REST endpoint for saving InventoryLibraryStone
	 * 
	 */
	@PostMapping("")
	public ResponseEntity<InventoryLibraryStoneResponseDTO> saveInventoryLibraryStone(
			@RequestBody InventoryLibraryStoneRequestDTO dataReqDTO) throws Exception {

		InventoryLibraryStoneResponseDTO savedrespData = invLibStoneService.saveInventoryLibraryStone(dataReqDTO);

		return ResponseEntity.ok(savedrespData);
	}
	/**
	 * This REST endpoint for updating InventoryLibraryStone by Id
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<InventoryLibraryStoneResponseDTO> updateInventoryLibraryStone(
			@RequestBody InventoryLibraryStoneRequestDTO dataReqDTO, @PathVariable Long id) throws Exception {

		InventoryLibraryStoneResponseDTO updatedrespData = invLibStoneService.updateInventoryLibraryStone(id, dataReqDTO);
		return ResponseEntity.ok(updatedrespData);
	}
	/**
	 * This REST endpoint exposes the search interface for searching
	 * InventoryLibraryStone
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryLibraryStoneResponseDTO>> findInventoryLibraryStoneByCriteria(
			@RequestBody InventoryLibraryStoneRequestDTO dataReqDTO) throws Exception {

		List<InventoryLibraryStoneResponseDTO> selectedInventoryLibraryStone = invLibStoneService
				.findInventoryLibraryStoneByCriteria(dataReqDTO);

		return ResponseEntity.ok(selectedInventoryLibraryStone);
	}

	/**
	 * This REST endpoint exposes the delete InventoryLibraryStone by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryLibraryStoneResponseDTO> deleteInventoryLibraryStoneById(@PathVariable("id") Long id) {
		InventoryLibraryStoneResponseDTO InventoryLibraryStoneResponseDTO = invLibStoneService
				.deleteInventoryLibraryStoneById(id);
		return ResponseEntity.ok(InventoryLibraryStoneResponseDTO);
	}
}
