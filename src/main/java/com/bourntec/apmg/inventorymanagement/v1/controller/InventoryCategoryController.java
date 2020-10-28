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

import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryCategoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvCategoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InvCategoryService;

/**
 * @author Srijini T.S
 *
 */
@RestController(value = "InventoryCategoryController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/invcategory")
public class InventoryCategoryController {

	@Autowired
	InvCategoryService invCategoryService;

	@GetMapping("")
	public ResponseEntity<List<InventoryCategory>> fetchAllInventoryCategories() throws Exception {

		List<InventoryCategory> allInvCats = invCategoryService.findAllInvCategories();
		return ResponseEntity.ok(allInvCats);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          invCategories by id
	 * @param category
	 * @return ResponseEntity<InvCategoryResponseDTO>
	 */

	@GetMapping("/{category}")
	public ResponseEntity<InvCategoryResponseDTO> fetchByCategoryId(@PathVariable String category) throws Exception {

		InvCategoryResponseDTO selectedInvCats = invCategoryService.findInvCategoryById(category);

		return ResponseEntity.ok(selectedInvCats);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          inventory category
	 * @param InventoryCategoryRequestDTO
	 * @return ResponseEntity<InvCategoryResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<InvCategoryResponseDTO> saveCountrySetup(
			@RequestBody InventoryCategoryRequestDTO invCatReqDTO) throws Exception {

		InvCategoryResponseDTO invCatRespDTO = invCategoryService.saveInvCategories(invCatReqDTO);

		return ResponseEntity.ok(invCatRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          brand by Id
	 * @param InventoryCategoryRequestDTO, category
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/{category}")
	public ResponseEntity<InvCategoryResponseDTO> updateInvCat(@RequestBody InventoryCategoryRequestDTO invCatReqDTO,
			@PathVariable String category) throws Exception {

		InvCategoryResponseDTO invCategoryResDTO = invCategoryService.updateInvCategoryById(category, invCatReqDTO);
		return ResponseEntity.ok(invCategoryResDTO);
	}

	/**
	 * This API delete an StoneOrigin object.
	 * 
	 * @param id
	 * @return InvCategoryResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<InvCategoryResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		InvCategoryResponseDTO responsetDTO = invCategoryService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on category object.
	 * 
	 * @param InventoryCategoryRequestDTO
	 * @return List<InvCategoryResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<InvCategoryResponseDTO>> search(
			@RequestBody InventoryCategoryRequestDTO requestDTO) throws Exception {
		List<InvCategoryResponseDTO> responsetDTO = invCategoryService.search(requestDTO);
		return ResponseEntity.ok(responsetDTO);
	}

}
