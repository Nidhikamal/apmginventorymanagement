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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesSettingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesSettingResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesSettingService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/codessetting")
public class CodesSettingController {
	@Autowired
	CodesSettingService codesSettingService;

	/**
	 * This API fetches all settingDetails
	 * 
	 * @return List<CodeSettingResponseDTO
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<CodesSettingResponseDTO>> findAllCodeSettings() throws Exception {
		List<CodesSettingResponseDTO> codeSettingResponseDTOList = codesSettingService.findAllCodeSettings();
		return ResponseEntity.ok(codeSettingResponseDTOList);
	}

	/**
	 * This API fetches by settingId
	 * 
	 * @param settingId
	 * @return ResponseEntity<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{settingId}")
	public ResponseEntity<CodesSettingResponseDTO> findBycodeSetting(@PathVariable String settingId) throws Exception {
		CodesSettingResponseDTO codeClarityResponseDTO = codesSettingService.findBycodeSetting(settingId);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API creates new settingDetails object
	 * 
	 * @param CodesSettingRequestDTO
	 * @return ResponseEntity<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CodesSettingResponseDTO> savecodeSetting(
			@RequestBody CodesSettingRequestDTO codeSettingRequestDTO) throws Exception {
		CodesSettingResponseDTO codeClaspResponsetDTO = codesSettingService.savecodeSetting(codeSettingRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API updated new settingDetails object
	 * 
	 * @param CodesSettingRequestDTO
	 * @return ResponseEntity<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{settingId}")
	public ResponseEntity<CodesSettingResponseDTO> updatecodeSetting(@PathVariable String settingId,
			@RequestBody CodesSettingRequestDTO codeSettingRequestDTO) throws Exception {
		CodesSettingResponseDTO codeClaspResponsetDTO = codesSettingService.updatecodeSetting(settingId,
				codeSettingRequestDTO);
		return ResponseEntity.ok(codeClaspResponsetDTO);
	}

	/**
	 * This API delete an claspMaintainanceDetails
	 * 
	 * @param id
	 * @return CodeSettingResponseDTO
	 * @throws Exception
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<CodesSettingResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CodesSettingResponseDTO responsetDTO = codesSettingService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodeShapeRequestDTO
	 * @return List<CodeSettingResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodesSettingResponseDTO>> searchShapeMaintance(
			@RequestBody CodesSettingRequestDTO claspRequestDTO) throws Exception {
		List<CodesSettingResponseDTO> responsetDTO = codesSettingService.search(claspRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
