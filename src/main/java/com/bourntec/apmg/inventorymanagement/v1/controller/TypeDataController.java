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

import com.bourntec.apmg.entity.TypeData;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.TypeDataService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/typedata")
public class TypeDataController {

	@Autowired
	TypeDataService typeDataService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for getting all
	 *          TypeData
	 * @param
	 * @return ResponseEntity<InventoryRank>
	 */
	@GetMapping("")
	public ResponseEntity<List<TypeData>> fetchAllTypeDatas() throws Exception {

		List<TypeData> alltypedatas = typeDataService.findAllTypeDatas();
		return ResponseEntity.ok(alltypedatas);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          TypeData by typeCode
	 * @param typeCode
	 * @return ResponseEntity<TypeDataResponseDTO>
	 */

	@GetMapping("/{typeCode}")
	public ResponseEntity<TypeDataResponseDTO> fetchByTypeCode(@PathVariable String typeCode) throws Exception {

		TypeDataResponseDTO typeDataResDTO = typeDataService.findTypeDataById(typeCode);

		return ResponseEntity.ok(typeDataResDTO);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          TypeData
	 * @param
	 * @return ResponseEntity<TypeDataResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<TypeDataResponseDTO> saveTypeData(@RequestBody TypeDataRequestDTO typeDataReqDTO)
			throws Exception {

		TypeDataResponseDTO typeDataResDTO = typeDataService.saveTypeData(typeDataReqDTO);

		return ResponseEntity.ok(typeDataResDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          TypeData by Id
	 * @param TypeDataRequestDTO,typeCode
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/{typeCode}")
	public ResponseEntity<TypeDataResponseDTO> updateTypeData(@RequestBody TypeDataRequestDTO typeDataReqDTO,
			@PathVariable String typeCode) throws Exception {

		TypeDataResponseDTO typeDataResDTO = typeDataService.updateTypeDataById(typeCode, typeDataReqDTO);
		return ResponseEntity.ok(typeDataResDTO);
	}

	/**
	 * This API delete an StoneOrigin object.
	 * 
	 * @param id
	 * @return TypeDataResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<TypeDataResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		TypeDataResponseDTO responsetDTO = typeDataService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param TypeDataRequestDTO
	 * @return List<TypeDataResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<TypeDataResponseDTO>> searchShapeMaintance(
			@RequestBody TypeDataRequestDTO shapeRequestDTO) throws Exception {
		List<TypeDataResponseDTO> responsetDTO = typeDataService.search(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
