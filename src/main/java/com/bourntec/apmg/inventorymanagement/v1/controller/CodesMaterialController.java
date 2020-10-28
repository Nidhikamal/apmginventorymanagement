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

import com.bourntec.apmg.entity.CodesMaterial;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesMaterailRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesMaterialResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesMaterialService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/materialcodes")
public class CodesMaterialController {
	@Autowired
	CodesMaterialService codesMaterialService;

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          all material codes
	 * @param
	 * @return ResponseEntity List<CodesMaterial>
	 */
	@GetMapping("")
	public ResponseEntity<List<CodesMaterial>> fetchAllMaterialCodes() throws Exception {

		List<CodesMaterial> allMaterialCodes = codesMaterialService.findAllMaterialCodes();
		return ResponseEntity.ok(allMaterialCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          Material Codes by id
	 * @param materialId
	 * @return ResponseEntity<CodesMaterialResponseDTO>
	 */

	@GetMapping("/{materialId}")
	public ResponseEntity<CodesMaterialResponseDTO> fetchByMaterialId(@PathVariable String materialId)
			throws Exception {

		CodesMaterialResponseDTO selectedMaterialCodes = codesMaterialService.findMaterialCodesById(materialId);

		return ResponseEntity.ok(selectedMaterialCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          Materail Codes
	 * @param CodesMaterailRequestDTO
	 * @return ResponseEntity<CodesMaterialResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CodesMaterialResponseDTO> saveMaterailCodes(
			@RequestBody CodesMaterailRequestDTO codesMaterialReqDTO) throws Exception {

		CodesMaterialResponseDTO savedMaterailCodesRespDTO = codesMaterialService
				.saveMaterialCodes(codesMaterialReqDTO);

		return ResponseEntity.ok(savedMaterailCodesRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          materail codes by Material Id
	 * @param CodesMaterailRequestDTO,materialId
	 * @return ResponseEntity<CodesMaterialResponseDTO>
	 */

	@PutMapping("/{materialId}")
	public ResponseEntity<Object> updateMaterialCodes(@RequestBody CodesMaterailRequestDTO codesMaterialReqDTO,
			@PathVariable String materialId) throws Exception {

		CodesMaterialResponseDTO updatedMaterialCodesResDTO = codesMaterialService.updateMaterialCodesById(materialId,
				codesMaterialReqDTO);
		return ResponseEntity.ok(updatedMaterialCodesResDTO);
	}

	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<CodesMaterialResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CodesMaterialResponseDTO responsetDTO = codesMaterialService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodesMaterailRequestDTO
	 * @return List<CodesMaterialResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodesMaterialResponseDTO>> searchShapeMaintance(
			@RequestBody CodesMaterailRequestDTO requestDTO) throws Exception {
		List<CodesMaterialResponseDTO> responsetDTO = codesMaterialService.search(requestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
