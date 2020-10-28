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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberKeywordService;

/**
 * Controller claas for TNumberKeyword
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/TNumberKeyword")
public class TNumberKeywordController {

	@Autowired
	TNumberKeywordService tNumberKeywordService;

	/**
	 * This REST endpoint exposes for get all numberkeywords details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<TNumberKeywordResponseDTO>> fetchAllData() throws Exception {

		List<TNumberKeywordResponseDTO> allData = tNumberKeywordService.findAllTNumberKeywords();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes for get numberkeywords by id
	 * detailsfindAllTNumberKeywords
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TNumberKeywordResponseDTO> getTNumberKeywordById(@PathVariable Long id) throws Exception {

		TNumberKeywordResponseDTO allData = tNumberKeywordService.getTNumberKeywordById(id);
		return ResponseEntity.ok(allData);
	}

	/**
	 * Endpoint for save
	 * 
	 * @param tNumberKeywordRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<TNumberKeywordResponseDTO> saveTNumberKeywords(
			@RequestBody TNumberKeywordRequestDTO tNumberKeywordRequestDTO) throws Exception {

		TNumberKeywordResponseDTO savedrespData = tNumberKeywordService.saveTNumberKeywords(tNumberKeywordRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * Endpoint for search
	 * 
	 * @param tNumberKeywordRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<TNumberKeywordResponseDTO>> findTNumberKeywordByCriteria(
			@RequestBody TNumberKeywordRequestDTO tNumberKeywordRequestDTO) throws Exception {

		List<TNumberKeywordResponseDTO> keywordResponseDTO = tNumberKeywordService
				.findTNumberKeywordByCriteria(tNumberKeywordRequestDTO);

		return ResponseEntity.ok(keywordResponseDTO);

	}

	/**
	 * Endpoint for updation
	 * 
	 * @param tNumberKeywordRequestDTO
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TNumberKeywordResponseDTO> updateTNumberKeywords(
			@RequestBody TNumberKeywordRequestDTO tNumberKeywordRequestDTO, @PathVariable Long id) throws Exception {

		TNumberKeywordResponseDTO updatedrespData = tNumberKeywordService.updateTNumberKeyword(id,
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
	private ResponseEntity<TNumberKeywordResponseDTO> deleteJobProductKeywordsById(@PathVariable("id") Long id)
			throws Exception {
		TNumberKeywordResponseDTO keywordResponseDTO = tNumberKeywordService.deleteTNumberKeywordById(id);
		return ResponseEntity.ok(keywordResponseDTO);
	}

}