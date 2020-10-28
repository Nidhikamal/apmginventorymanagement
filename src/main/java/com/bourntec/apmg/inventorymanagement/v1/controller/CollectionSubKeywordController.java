package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionSubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionSubKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CollectionSubKeywordService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/collectionsubkeyword")
public class CollectionSubKeywordController {
	@Autowired
	CollectionSubKeywordService collectionSubKeywordService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving sub
	 *          CollectionKeyword
	 * @param
	 * @return ResponseEntity<CollectionSubKeywordResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CollectionSubKeywordResponseDTO> saveCollectionKeywords(
			@RequestBody CollectionSubKeywordRequestDTO subKeywordRequestDTOs) throws Exception {

		CollectionSubKeywordResponseDTO keywordResDTO = collectionSubKeywordService
				.saveCollectionSubKeywords(subKeywordRequestDTOs);

		return ResponseEntity.ok(keywordResDTO);

	}
	@PutMapping("/{subKeyId}")
	public ResponseEntity<CollectionSubKeywordResponseDTO> updateSubKey(@PathVariable String subKeyId,
			@RequestBody CollectionSubKeywordResponseDTO codeClaspRequestDTO) throws Exception {
		CollectionSubKeywordResponseDTO codeClaspResponsetDTO = collectionSubKeywordService.updateSubKey(subKeyId, codeClaspRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}
	/**
	 * Get all CollectionSubKeyword list
	 * 
	 * @return List<CollectionSubKeywordResponseDTO>
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<CollectionSubKeywordResponseDTO>> getAll() throws Exception {
		List<CollectionSubKeywordResponseDTO> keywordResponseDTOs = collectionSubKeywordService.getAll();
		return ResponseEntity.ok(keywordResponseDTOs);
	}

	/**
	 * Get CollectionSubKeyword of {subId}
	 * @param userId
	 * @return CollectionSubKeywordResponseDTO
	 * @throws Exception
	 */
	@GetMapping("/{subKeyId}")
	public ResponseEntity<CollectionSubKeywordResponseDTO> getById(@PathVariable String subKeyId) throws Exception {
		CollectionSubKeywordResponseDTO keywordResponseDTOs = collectionSubKeywordService.getById(subKeyId);
		return ResponseEntity.ok(keywordResponseDTOs);
	}

	/**
	 * Method for Search
	 * 
	 * @param CollectionSubKeywordRequestDTO
	 * @return ResponseEntity<List<PassAccessListResponseDTO>>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CollectionSubKeywordResponseDTO>> getUserSearchList(@RequestBody CollectionSubKeywordRequestDTO subKeywordRequestDTOs,
			@RequestParam int page, @RequestParam int size)
			throws Exception {
		List<CollectionSubKeywordResponseDTO> responseDTOs = collectionSubKeywordService.search(subKeywordRequestDTOs,page,size);
		return ResponseEntity.ok(responseDTOs);
	}
}
