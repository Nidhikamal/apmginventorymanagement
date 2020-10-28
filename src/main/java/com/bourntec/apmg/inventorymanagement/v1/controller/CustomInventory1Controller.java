package com.bourntec.apmg.inventorymanagement.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CustomInventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomInventory1ResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CustomInventory1Service;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/custominventory1")
public class CustomInventory1Controller {

	@Autowired
	CustomInventory1Service inventoryService;

	/**
	 * @Author: Amal This REST endpoint exposes the ajax call for getting material
	 *          price and weight by karat
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@PostMapping("/getweightnpricebykarat")
	public ResponseEntity<CustomInventory1ResponseDTO> getMatPricenWieght(@RequestBody CustomInventory1RequestDTO invReqDTO)
			throws Exception {

		CustomInventory1ResponseDTO inv1ResDTO = inventoryService.getPriceandWeightfromKarat(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the ajax call for getting material
	 *          price by weight
	 * @param
	 * @return ResponseEntity<Inventory1ResponseDTO>
	 */

	@PostMapping("/getpricebyweight")
	public ResponseEntity<CustomInventory1ResponseDTO> getPriceByWeight(@RequestBody CustomInventory1RequestDTO invReqDTO)
			throws Exception {

		CustomInventory1ResponseDTO inv1ResDTO = inventoryService.getPricefromWeight(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the ajax call for getting material
	 *          price by weight
	 * @param
	 * @return ResponseEntity<CustomInventory1ResponseDTO>
	 */

	@PostMapping("/getpricebyitemcost")
	public ResponseEntity<CustomInventory1ResponseDTO> getPriceByItemCost(@RequestBody CustomInventory1RequestDTO invReqDTO)
			throws Exception {

		CustomInventory1ResponseDTO inv1ResDTO = inventoryService.getPricefromItemCost(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

	@PostMapping("/getpricebysalesprice")
	public ResponseEntity<CustomInventory1ResponseDTO> getPriceBySalesPrice(@RequestBody CustomInventory1RequestDTO invReqDTO)
			throws Exception {

		CustomInventory1ResponseDTO inv1ResDTO = inventoryService.getPricefromSalesPrice(invReqDTO);
		return ResponseEntity.ok(inv1ResDTO);
	}

}
