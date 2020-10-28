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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory2RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory2ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.Inventory2Service;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventory2")
public class Inventory2Controller {

	@Autowired
	Inventory2Service inventory2Service;
	/**
	 * This API saves a Inventory2
	 * 
	 * @param Inventory2RequestDTO
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<Inventory2ResponseDTO> saveInventory2(
			@RequestBody Inventory2RequestDTO inventory2Requestdto) throws Exception {
		Inventory2ResponseDTO inventory2Responsedto = inventory2Service.saveInventory2(inventory2Requestdto);
		return ResponseEntity.ok(inventory2Responsedto);
	}

	/**
	 * This API updates a Inventory2
	 * 
	 * @param itemCode
	 * @param Inventory2RequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{itemCode}")
	public ResponseEntity<Inventory2ResponseDTO> updateInventory2(@PathVariable String itemCode,
			@RequestBody Inventory2RequestDTO inventory2Requestdto) throws Exception {
		Inventory2ResponseDTO inventory2Responsedto = inventory2Service
				.updateInventory2(itemCode, inventory2Requestdto);
		return ResponseEntity.ok(inventory2Responsedto);
	}

	/**
	 * This API fetches Inventory2 according to {itemCode}
	 * 
	 * @param itemCode
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{itemCode}")
	public ResponseEntity<Inventory2ResponseDTO> getById(@PathVariable String itemCode)
			throws Exception {
		Inventory2ResponseDTO inventory2Responsedto = inventory2Service.getById(itemCode);
		return ResponseEntity.ok(inventory2Responsedto);
	}

	/**
	 * This API fetches all Inventory2s.
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<Inventory2ResponseDTO>> getAll() throws Exception {
		List<Inventory2ResponseDTO> inventory2ResponseList = inventory2Service.getAll();
		return ResponseEntity.ok(inventory2ResponseList);
	}

	/**
	 * REST endpoint exposes the search interface for searching a Inventory2
	 * dynamically
	 * 
	 * @param Inventory2RequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<Inventory2ResponseDTO>> fetchByInventory2(
			@RequestBody Inventory2RequestDTO inventory2Requestdto) throws Exception {

		List<Inventory2ResponseDTO> inventory2ResponseList = inventory2Service.fetchByInventory2(inventory2Requestdto);

		return ResponseEntity.ok(inventory2ResponseList);
	}

	/**
	 * This API delete a Inventory2
	 * 
	 * @param itemCode
	 * @return
	 */
	@DeleteMapping("/{itemCode}")
	public ResponseEntity<Inventory2ResponseDTO> deleteMemoManifest(@PathVariable String itemCode) {
		Inventory2ResponseDTO inventory2Response = inventory2Service.deleteInventory2(itemCode);
		return ResponseEntity.ok(inventory2Response);
	}
}
