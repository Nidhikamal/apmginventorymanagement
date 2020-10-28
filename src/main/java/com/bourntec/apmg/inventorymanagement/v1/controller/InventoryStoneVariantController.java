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
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryStoneVariantRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryStoneVariantResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryStoneVariantService;
/**
 * Controller for InventoryStoneVariant
 * @author AMAL
 *
 */
@RestController(value = "InventoryStoneVariantController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventorystonevariant")
public class InventoryStoneVariantController {
	@Autowired
	InventoryStoneVariantService invStoneVariant;
	/**
	 * This REST endpoint exposes the search interface for returning all Inventory Library   Stones
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InventoryStoneVariantResponseDTO>> fetchAllData() throws Exception {

		List<InventoryStoneVariantResponseDTO> allData = invStoneVariant.findAllInventoryStoneVariants();
		return ResponseEntity.ok(allData);
	}
	/**
	 * This REST endpoint exposes the search interface for returning  Inventory Library   Stones
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<InventoryStoneVariantResponseDTO> getInventoryStoneVariantById(@PathVariable Long id)
			throws Exception {

		InventoryStoneVariantResponseDTO selectedInventoryStoneVariant = invStoneVariant
				.getInventoryStoneVariantById(id);

		return ResponseEntity.ok(selectedInventoryStoneVariant);
	}
	/**
	 * This REST endpoint for saving InventoryStoneVariant
	 * 
	 */
	@PostMapping("")
	public ResponseEntity<InventoryStoneVariantResponseDTO> saveInventoryStoneVariant(
			@RequestBody InventoryStoneVariantRequestDTO dataReqDTO) throws Exception {

		InventoryStoneVariantResponseDTO savedrespData = invStoneVariant.saveInventoryStoneVariant(dataReqDTO);

		return ResponseEntity.ok(savedrespData);
	}
	/**
	 * This REST endpoint for updating InventoryStoneVariant by Id
	 * 
	 */
	@PutMapping("/{id}")
	public ResponseEntity<InventoryStoneVariantResponseDTO> updateInventoryStoneVariant(
			@RequestBody InventoryStoneVariantRequestDTO dataReqDTO, @PathVariable Long id) throws Exception {

		InventoryStoneVariantResponseDTO updatedrespData = invStoneVariant.updateInventoryStoneVariant(id, dataReqDTO);
		return ResponseEntity.ok(updatedrespData);
	}
	/**
	 * This REST endpoint exposes the search interface for searching
	 * InventoryStoneVariant
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InventoryStoneVariantResponseDTO>> findInventoryStoneVariantByCriteria(
			@RequestBody InventoryStoneVariantRequestDTO dataReqDTO) throws Exception {

		List<InventoryStoneVariantResponseDTO> selectedInventoryStoneVariant = invStoneVariant
				.findInventoryStoneVariantByCriteria(dataReqDTO);

		return ResponseEntity.ok(selectedInventoryStoneVariant);
	}

	/**
	 * This REST endpoint exposes the delete InventoryStoneVariant by id
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<InventoryStoneVariantResponseDTO> deleteInventoryStoneVariantById(@PathVariable("id") Long id) {
		InventoryStoneVariantResponseDTO InventoryStoneVariantResponseDTO = invStoneVariant
				.deleteInventoryStoneVariantById(id);
		return ResponseEntity.ok(InventoryStoneVariantResponseDTO);
	}
}
