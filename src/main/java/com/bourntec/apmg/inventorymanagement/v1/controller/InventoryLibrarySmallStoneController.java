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
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryLibrarySmallStoneRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryLibrarySmallStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryLibrarySmallStoneService;
/**
 * Controller for InventoryLibrarySmallStone
 * @author AMAL
 *
 */
@RestController(value = "InventoryLibrarySmallStoneController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorylibrarysmallstone")
public class InventoryLibrarySmallStoneController {
	@Autowired
	InventoryLibrarySmallStoneService invLibSmallStoneService;
	/**
	 * This REST endpoint exposes the search interface for returning all Inventory Library Small Stones
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryLibrarySmallStoneResponseDTO>> fetchAllData() throws Exception {

		List<InventoryLibrarySmallStoneResponseDTO> allData = invLibSmallStoneService.findAllInventoryLibrarySmallStones();
		return ResponseEntity.ok(allData);
	}
	/**
	 * This REST endpoint exposes the search interface for returning  Inventory Library Small Stones
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<InventoryLibrarySmallStoneResponseDTO> getInventoryLibrarySmallStoneById(@PathVariable Long id)
			throws Exception {

		InventoryLibrarySmallStoneResponseDTO selectedInventoryLibrarySmallStone = invLibSmallStoneService
				.getInventoryLibrarySmallStoneById(id);

		return ResponseEntity.ok(selectedInventoryLibrarySmallStone);
	}
	/**
	 * This REST endpoint for saving InventoryLibrarySmallStone
	 * 
	 */
	@PostMapping("")
	public ResponseEntity<InventoryLibrarySmallStoneResponseDTO> saveInventoryLibrarySmallStone(
			@RequestBody InventoryLibrarySmallStoneRequestDTO dataReqDTO) throws Exception {

		InventoryLibrarySmallStoneResponseDTO savedrespData = invLibSmallStoneService.saveInventoryLibrarySmallStone(dataReqDTO);

		return ResponseEntity.ok(savedrespData);
	}
	/**
	 * This REST endpoint for updating InventoryLibrarySmallStone by Id
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<InventoryLibrarySmallStoneResponseDTO> updateInventoryLibrarySmallStone(
			@RequestBody InventoryLibrarySmallStoneRequestDTO dataReqDTO, @PathVariable Long id) throws Exception {

		InventoryLibrarySmallStoneResponseDTO updatedrespData = invLibSmallStoneService.updateInventoryLibrarySmallStone(id, dataReqDTO);
		return ResponseEntity.ok(updatedrespData);
	}
	/**
	 * This REST endpoint exposes the search interface for searching
	 * InventoryLibrarySmallStone
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryLibrarySmallStoneResponseDTO>> findInventoryLibrarySmallStoneByCriteria(
			@RequestBody InventoryLibrarySmallStoneRequestDTO dataReqDTO) throws Exception {

		List<InventoryLibrarySmallStoneResponseDTO> selectedInventoryLibrarySmallStone = invLibSmallStoneService
				.findInventoryLibrarySmallStoneByCriteria(dataReqDTO);

		return ResponseEntity.ok(selectedInventoryLibrarySmallStone);
	}

	/**
	 * This REST endpoint exposes the delete InventoryLibrarySmallStone by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryLibrarySmallStoneResponseDTO> deleteInventoryLibrarySmallStoneById(@PathVariable("id") Long id) {
		InventoryLibrarySmallStoneResponseDTO InventoryLibrarySmallStoneResponseDTO = invLibSmallStoneService
				.deleteInventoryLibrarySmallStoneById(id);
		return ResponseEntity.ok(InventoryLibrarySmallStoneResponseDTO);
	}
}
