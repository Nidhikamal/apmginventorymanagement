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

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryCategoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvCategoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.Inventory1Service;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/inventory1")
public class Inventory1Controller {

	@Autowired
	Inventory1Service inventoryService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Inventory
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<Inventory1ResponseDTO> saveinventory(@RequestBody Inventory1RequestDTO invReqDTO)
			throws Exception {

		Inventory1ResponseDTO invRespDTO = inventoryService.saveInvetoryData(invReqDTO);

		return ResponseEntity.ok(invRespDTO);

	}

	@PutMapping("/{invId}")
	public ResponseEntity<Inventory1ResponseDTO> updateInvCat(@RequestBody Inventory1RequestDTO reqDTO,
			@PathVariable String invId) throws Exception {

		Inventory1ResponseDTO resDTO = inventoryService.updateInv(invId, reqDTO);
		return ResponseEntity.ok(resDTO);
	}

	/**
	 * @Author: Srijini This REST endpoint for get detials of an inv item
	 * 
	 * @param invId
	 * @return ResponseEntity<Inventory1>
	 */

	@GetMapping("/{invId}")
	public ResponseEntity<Inventory1> fetchByCategoryId(@PathVariable String invId) throws Exception {

		Inventory1 selectedInv = inventoryService.findByInvItemId(invId);

		return ResponseEntity.ok(selectedInv);
	}

	/**
	 * @author naveen AP 139-AP240 Sales order search Method for Simple search
	 * 
	 * @param Inventory1RequestDTO
	 * @return List<Inventory1ResponseDTO>
	 * @throws Exception
	 */
	/*
	 * @PostMapping("/search") public ResponseEntity<List<Inventory1ResponseDTO>>
	 * invSearch(@RequestBody Inventory1RequestDTO inventory1RequestDTO,
	 * 
	 * @RequestParam int page, @RequestParam int size) throws Exception {
	 * 
	 * List<Inventory1ResponseDTO> orderDataList =
	 * inventoryService.inventoryOrderSearch(inventory1RequestDTO, page, size);
	 * return ResponseEntity.ok(orderDataList); }
	 */
	@PostMapping("/search")
	public ResponseEntity<List<Inventory1>> invSearch(@RequestBody Inventory1RequestDTO inventory1RequestDTO,
			@RequestParam int page, @RequestParam int size) throws Exception {

		List<Inventory1> orderDataList = inventoryService.inventory1Search(inventory1RequestDTO);
		return ResponseEntity.ok(orderDataList);
	}

}
