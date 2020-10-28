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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberSubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberSubKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberSubKeywordService;

/**
 * Controller claas for TNumberSubKeyword
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/TNumberSubKeyword")
public class TNumberSubKeywordController {

	@Autowired
	TNumberSubKeywordService tNumberSubKeywordService;

	/**
	 * This REST endpoint exposes for get all TNumberSubKeywords details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<TNumberSubKeywordResponseDTO>> fetchAllData() throws Exception {

		List<TNumberSubKeywordResponseDTO> allData = tNumberSubKeywordService.findAllTNumberSubKeywords();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes for get TNumberSubKeywords by id
	 * detailsfindAllTNumberSubKeywords
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TNumberSubKeywordResponseDTO> getTNumberKeywordById(@PathVariable Long id) throws Exception {

		TNumberSubKeywordResponseDTO allData = tNumberSubKeywordService.getTNumberSubKeywordById(id);
		return ResponseEntity.ok(allData);
	}

	/**
	 * Endpoint for save
	 * 
	 * @param tNumberSubKeywordRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<TNumberSubKeywordResponseDTO> saveTTNumberSubKeywords(
			@RequestBody TNumberSubKeywordRequestDTO tNumberSubKeywordRequestDTO) throws Exception {

		TNumberSubKeywordResponseDTO savedrespData = tNumberSubKeywordService
				.saveTNumberSubKeywords(tNumberSubKeywordRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * Endpoint for search
	 * 
	 * @param tNumberSubKeywordRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<TNumberSubKeywordResponseDTO>> findTNumberKeywordByCriteria(
			@RequestBody TNumberSubKeywordRequestDTO tNumberSubKeywordRequestDTO) throws Exception {

		List<TNumberSubKeywordResponseDTO> keywordResponseDTO = tNumberSubKeywordService
				.findTNumberSubKeywordByCriteria(tNumberSubKeywordRequestDTO);

		return ResponseEntity.ok(keywordResponseDTO);

	}

	/**
	 * Endpoint for updation
	 * 
	 * @param tNumberSubKeywordRequestDTO
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TNumberSubKeywordResponseDTO> updateTNumberSubKeywords(
			@RequestBody TNumberSubKeywordRequestDTO tNumberKeywordRequestDTO, @PathVariable Long id) throws Exception {

		TNumberSubKeywordResponseDTO updatedrespData = tNumberSubKeywordService.updateTNumberSubKeyword(id,
				tNumberKeywordRequestDTO);
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
	private ResponseEntity<TNumberSubKeywordResponseDTO> deleteTNumberSubKeywordById(@PathVariable("id") Long id)
			throws Exception {
		TNumberSubKeywordResponseDTO keywordResponseDTO = tNumberSubKeywordService.deleteTNumberSubKeywordById(id);
		return ResponseEntity.ok(keywordResponseDTO);
	}

}