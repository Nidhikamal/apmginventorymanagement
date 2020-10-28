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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberService;

/**
 * Controller claas for TNumber
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/TNumber")
public class TNumberController {

	@Autowired
	TNumberService tNumberService;

	/**
	 * This REST endpoint exposes for get all numbers details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<TNumberResponseDTO>> fetchAllData() throws Exception {

		List<TNumberResponseDTO> allData = tNumberService.findAllTNumbers();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes for get numbers by id
	 * detailsfindAllTNumbers
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TNumberResponseDTO> getTNumberById(@PathVariable Long id) throws Exception {

		TNumberResponseDTO allData = tNumberService.getTNumberById(id);
		return ResponseEntity.ok(allData);
	}

	/**
	 * Endpoint for save
	 * 
	 * @param tNumberRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<TNumberResponseDTO> saveTNumbers(
			@RequestBody TNumberRequestDTO tNumberRequestDTO) throws Exception {

		TNumberResponseDTO savedrespData = tNumberService.saveTNumbers(tNumberRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * Endpoint for search
	 * 
	 * @param tNumberRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<TNumberResponseDTO>> findTNumberByCriteria(
			@RequestBody TNumberRequestDTO tNumberRequestDTO) throws Exception {

		List<TNumberResponseDTO> ResponseDTO = tNumberService
				.findTNumberByCriteria(tNumberRequestDTO);

		return ResponseEntity.ok(ResponseDTO);

	}

	/**
	 * Endpoint for updation
	 * 
	 * @param tNumberRequestDTO
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TNumberResponseDTO> updateTNumbers(
			@RequestBody TNumberRequestDTO tNumberRequestDTO, @PathVariable Long id) throws Exception {

		TNumberResponseDTO updatedrespData = tNumberService.updateTNumber(id,
				tNumberRequestDTO);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * Endpoint for deletion
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	private ResponseEntity<TNumberResponseDTO> deleteJobProductsById(@PathVariable("id") Long id)
			throws Exception {
		TNumberResponseDTO ResponseDTO = tNumberService.deleteTNumberById(id);
		return ResponseEntity.ok(ResponseDTO);
	}

}