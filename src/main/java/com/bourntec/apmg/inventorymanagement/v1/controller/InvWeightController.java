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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvWeightRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvWeightResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InvWeightService;


/**
 *  Controller for InvWeight Refactoring
 * 
 * @author VitemCodeya
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventoryweight")
public class InvWeightController {


	@Autowired
	InvWeightService  invWeightService;

	/**
	 * This REST endpoint exposes the search interface for returning all Inventory Weight
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<InvWeightResponseDTO>> fetchAllData() throws Exception {

		List<InvWeightResponseDTO> allData = invWeightService.findAllInvWeight();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes the search interface for returning Inventory Weight
	 *  by itemCode
	 * 
	 */

	@GetMapping("/{itemCode}")
	public ResponseEntity<InvWeightResponseDTO> getInvWeightById(@PathVariable String itemCode)
			throws Exception {

		InvWeightResponseDTO selectedInvWeight = invWeightService
				.getInvWeightById(itemCode);

		return ResponseEntity.ok(selectedInvWeight);
	}

	/**
	 * This REST endpoint for saving Inventory Weight
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<InvWeightResponseDTO> saveInvWeight(
			@RequestBody InvWeightRequestDTO invWeightRequestDTO) throws Exception {

		InvWeightResponseDTO savedrespData = invWeightService.saveInvWeight(invWeightRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST endpoint for updating Inventory Weight by Id
	 * 
	 */

	@PutMapping("/{itemCode}")
	public ResponseEntity<InvWeightResponseDTO> updateInvWeight(
			@RequestBody InvWeightRequestDTO invWeightRequestDTO, @PathVariable String itemCode) throws Exception {

		InvWeightResponseDTO updatedrespData = invWeightService.updateInvWeight(itemCode,
				invWeightRequestDTO);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST endpoint exposes the search interface for searching
	 * Inventory Weight
	 */
	@PostMapping("/search")
	public ResponseEntity<List<InvWeightResponseDTO>> findInvWeightByCriteria(
			@RequestBody InvWeightRequestDTO invWeightRequestDTO) throws Exception {

		List<InvWeightResponseDTO> selectedInvWeightResponseDTO = invWeightService
				.findInvWeightByCriteria(invWeightRequestDTO);

		return ResponseEntity.ok(selectedInvWeightResponseDTO);
	}

	/**
	 * This REST endpoint exposes the delete Inventory Weight by itemCode
	 * 
	 * @param itemCode
	 * @return
	 */
	@DeleteMapping("/{itemCode}")
	private ResponseEntity<InvWeightResponseDTO> deleteInvWeightById(@PathVariable("itemCode") String itemCode) {
		InvWeightResponseDTO invWeightResponseDTO = invWeightService
				.deleteInvWeightById(itemCode);
		return ResponseEntity.ok(invWeightResponseDTO);
	}
}
