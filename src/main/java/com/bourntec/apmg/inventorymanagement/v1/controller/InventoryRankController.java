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

import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryRankRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryRankResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryRankService;

/**
 * @author Srijini T.S
 *
 */
@RestController(value = "InventoryRankController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invrank")
public class InventoryRankController {

	@Autowired
	InventoryRankService inventoryService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          inventory Ranks by Id
	 * @param
	 * @return ResponseEntity<InventoryRank>
	 */

	@GetMapping("")
	public ResponseEntity<List<InventoryRank>> fetchAllInventoryRanks() throws Exception {

		List<InventoryRank> allInvRanks = inventoryService.findAllInvRanks();
		return ResponseEntity.ok(allInvRanks);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          inventory rank by id
	 * @param rank
	 * @return ResponseEntity<InventoryRankResponseDTO>
	 */

	@GetMapping("/{rank}")
	public ResponseEntity<InventoryRankResponseDTO> fetchByRank(@PathVariable String rank) throws Exception {

		InventoryRankResponseDTO invRankResDTO = inventoryService.findInvRankById(rank);

		return ResponseEntity.ok(invRankResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Inventory rank
	 * @param InventoryRankRequestDTO
	 * @return ResponseEntity<InventoryRankResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<InventoryRankResponseDTO> saveInvrank(@RequestBody InventoryRankRequestDTO invRankReqDTO)
			throws Exception {

		InventoryRankResponseDTO invRankResDTO = inventoryService.saveInvRanks(invRankReqDTO);

		return ResponseEntity.ok(invRankResDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          Inventory rank by Id
	 * @param InventoryRankRequestDTO,rank
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/{rank}")
	public ResponseEntity<InventoryRankResponseDTO> updateInvRank(@RequestBody InventoryRankRequestDTO invRankReqDTO,
			@PathVariable String rank) throws Exception {

		InventoryRankResponseDTO invRankResDTO = inventoryService.updateInvRankById(rank, invRankReqDTO);
		return ResponseEntity.ok(invRankResDTO);
	}

	/**
	 * This API delete an StoneOrigin object.
	 * 
	 * @param id
	 * @return InventoryRankResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<InventoryRankResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		InventoryRankResponseDTO responsetDTO = inventoryService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodesShapeRequestDTO
	 * @return List<InventoryRankResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<InventoryRankResponseDTO>> searchShapeMaintance(
			@RequestBody InventoryRankRequestDTO shapeRequestDTO) throws Exception {
		List<InventoryRankResponseDTO> responsetDTO = inventoryService.search(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}