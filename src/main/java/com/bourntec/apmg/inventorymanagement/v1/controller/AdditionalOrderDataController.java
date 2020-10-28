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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.AdditionalOrderDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.AdditionalOrderDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.AdditionalOrderDataService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/sizemaintainance")
public class AdditionalOrderDataController {

	@Autowired
	AdditionalOrderDataService addtionalOrderDataService;

	/**
	 * This API fetches allSizeMaintainence details
	 * 
	 * @return List<AddtionalOrderDataResponsetDTO
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<AdditionalOrderDataResponseDTO>> findAllSizeMainatinence() throws Exception {
		List<AdditionalOrderDataResponseDTO> addtionalOrderDataResponsetDTOList = addtionalOrderDataService
				.findAllSizeMainatinence();
		return ResponseEntity.ok(addtionalOrderDataResponsetDTOList);
	}

	/**
	 * This API fetch an SizeMainatinence object.
	 * 
	 * @param userId
	 * @return ResponseEntity<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("/{id}")
	public ResponseEntity<AdditionalOrderDataResponseDTO> findSizeMainatinenceById(
			@PathVariable Long id) throws Exception {
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = addtionalOrderDataService
				.findSizeMainatinenceById(id);
		return ResponseEntity.ok(addtionalOrderDataResponsetDTO);
	}

	/**
	 * This API creates new SizeMaintainence object
	 * 
	 * @param AdditionalOrderDataRequestDTO
	 * @return ResponseEntity<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<AdditionalOrderDataResponseDTO> saveSizeMaintainence(
			@RequestBody AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception {
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = addtionalOrderDataService
				.saveSizeMaintainence(addtionalOrderDataRequestDTO);
		return ResponseEntity.ok(addtionalOrderDataResponsetDTO);
	}

	/**
	 * This API updates an SizeMaintainence object.
	 * 
	 * @param additionalDataValue
	 * @param AdditionalOrderDataRequestDTO
	 * @return ResponseEntity<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/{id}")
	public ResponseEntity<AdditionalOrderDataResponseDTO> updateSizeMaintainence(
			@PathVariable Long id,
			@RequestBody AdditionalOrderDataRequestDTO addtionalOrderDataRequestDTO) throws Exception {
		AdditionalOrderDataResponseDTO addtionalOrderDataResponsetDTO = addtionalOrderDataService
				.updateSizeMaintainence(id, addtionalOrderDataRequestDTO);
		return ResponseEntity.ok(addtionalOrderDataResponsetDTO);
	}

	/**
	 * This API delete an ShapeMaintance object.
	 * 
	 * @param id
	 * @return AddtionalOrderDataResponsetDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<AdditionalOrderDataResponseDTO> deleteShapeMaintance(@PathVariable Long id)
			throws Exception {
		AdditionalOrderDataResponseDTO responsetDTO = addtionalOrderDataService.deleteShapeMaintance(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on ShapeMaintance object.
	 * 
	 * @param CodesShapeRequestDTO
	 * @return List<AddtionalOrderDataResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<AdditionalOrderDataResponseDTO>> searchShapeMaintance(
			@RequestBody AdditionalOrderDataRequestDTO shapeRequestDTO) throws Exception {
		List<AdditionalOrderDataResponseDTO> responsetDTO = addtionalOrderDataService
				.searchSizeMaintance(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}

}
