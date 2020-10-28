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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.TNumberHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TNumberHistoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.TNumberHistoryService;

/**
 * Controller claas for TNumberHistory
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/TNumberHistory")
public class TNumberHistoryController {

	@Autowired
	TNumberHistoryService tNumberHistoryService;

	/**
	 * This REST endpoint exposes for get all tNumberHistory details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<TNumberHistoryResponseDTO>> fetchAllData() throws Exception {

		List<TNumberHistoryResponseDTO> allData = tNumberHistoryService.findAllTNumberHistorys();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST endpoint exposes for get tNumberHistory by id
	 * detailsfindAllTNumberHistorys
	 * 
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TNumberHistoryResponseDTO> getTNumberHistoryById(@PathVariable Long id) throws Exception {

		TNumberHistoryResponseDTO allData = tNumberHistoryService.getTNumberHistoryById(id);
		return ResponseEntity.ok(allData);
	}

	/**
	 * Endpoint for save
	 * 
	 * @param TNumberHistoryRequestDTO
	 * @return TNumberHistoryResponseDTO
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<TNumberHistoryResponseDTO> saveTNumberHistorys(
			@RequestBody TNumberHistoryRequestDTO tNumberHistoryRequestDTO) throws Exception {

		TNumberHistoryResponseDTO savedrespData = tNumberHistoryService.saveTNumberHistorys(tNumberHistoryRequestDTO);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * Endpoint for search
	 * 
	 * @param TNumberHistoryRequestDTO
	 * @return List<TNumberHistoryResponseDTO>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<TNumberHistoryResponseDTO>> findTNumberHistoryByCriteria(
			@RequestBody TNumberHistoryRequestDTO tNumberHistoryRequestDTO) throws Exception {

		List<TNumberHistoryResponseDTO> respData = tNumberHistoryService
				.findTNumberHistoryByCriteria(tNumberHistoryRequestDTO);

		return ResponseEntity.ok(respData);

	}

	/**
	 * Endpoint for updation
	 * 
	 * @param TNumberHistoryRequestDTO
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{id}")
	public ResponseEntity<TNumberHistoryResponseDTO> updateTNumberHistorys(
			@RequestBody TNumberHistoryRequestDTO tNumberHistoryRequestDTO, @PathVariable Long id) throws Exception {

		TNumberHistoryResponseDTO updatedrespData = tNumberHistoryService.updateTNumberHistory(id,
				tNumberHistoryRequestDTO);
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
	private ResponseEntity<TNumberHistoryResponseDTO> deleteTNumberHistoryById(@PathVariable("id") Long id)
			throws Exception {
		TNumberHistoryResponseDTO respData = tNumberHistoryService.deleteTNumberHistoryById(id);
		return ResponseEntity.ok(respData);
	}

}