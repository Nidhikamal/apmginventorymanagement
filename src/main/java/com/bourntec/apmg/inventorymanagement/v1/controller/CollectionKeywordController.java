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

import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CollectionKeywordService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/collectionkeyword")
public class CollectionKeywordController {

	@Autowired
	CollectionKeywordService inventoryService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          CollectionKeyword
	 * @param
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CollectionKeywordResponseDTO> saveCollectionKeywords(
			@RequestBody CollectionKeywordRequestDTO keywordReqDTO) throws Exception {

		CollectionKeywordResponseDTO keywordResDTO = inventoryService.saveCollectionKeywords(keywordReqDTO);

		return ResponseEntity.ok(keywordResDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          CollectionKeyword
	 * @param CollectionKeywordRequestDTO,keyId
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@PutMapping("/{keyId}")
	public ResponseEntity<Object> updateKeywords(@RequestBody CollectionKeywordRequestDTO keywordReqDTO,
			@PathVariable String keyId) throws Exception {

		CollectionKeywordResponseDTO keywordResDTO = inventoryService.updateCollectionKeywordsById(keyId,
				keywordReqDTO);
		return ResponseEntity.ok(keywordResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          CollectionKeywords
	 * @param
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@GetMapping("")
	public ResponseEntity<List<CollectionKeyword>> fetchAllCollectionKeywords() throws Exception {

		List<CollectionKeyword> allKeywords = inventoryService.findAllCollectionKeywords();
		return ResponseEntity.ok(allKeywords);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting
	 *          CollectionKeyword by Id
	 * @param keyWrd
	 * @return ResponseEntity<CollectionKeywordResponseDTO>
	 */

	@GetMapping("/{keyWrd}")
	public ResponseEntity<CollectionKeywordResponseDTO> fetchCollectionKeywordById(@PathVariable String keyWrd)
			throws Exception {

		CollectionKeywordResponseDTO keywordResDTO = inventoryService.findCollectionKeywordById(keyWrd);
		return ResponseEntity.ok(keywordResDTO);
	}

	/**
	 * This API delete an StoneOrigin object.
	 * 
	 * @param id
	 * @return TypeDataResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<CollectionKeywordResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CollectionKeywordResponseDTO responsetDTO = inventoryService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param TypeDataRequestDTO
	 * @return List<CollectionKeywordResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CollectionKeywordResponseDTO>> searchShapeMaintance(
			@RequestBody CollectionKeywordRequestDTO shapeRequestDTO) throws Exception {
		List<CollectionKeywordResponseDTO> responsetDTO = inventoryService.search(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
