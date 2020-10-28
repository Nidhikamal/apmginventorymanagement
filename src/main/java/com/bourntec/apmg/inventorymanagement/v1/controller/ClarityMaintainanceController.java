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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClarityRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClarityResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.ClarityMaintainanceService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/claritymaintainance")
public class ClarityMaintainanceController {

	@Autowired
	ClarityMaintainanceService clarityMaintainanceService;

	/**
	 * This API findAll clarityMaintainance details
	 * 
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<CodeClarityResponseDTO>> findAllCodeClarity() throws Exception {
		List<CodeClarityResponseDTO> addtionalOrderDataResponsetDTOList = clarityMaintainanceService
				.findAllCodeClarity();
		return ResponseEntity.ok(addtionalOrderDataResponsetDTOList);
	}

	/**
	 * This API finds CodeClarity By Id
	 * 
	 * @param clarityId
	 * @return ResponseEntity<CodeClarityResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{clarityId}")
	public ResponseEntity<CodeClarityResponseDTO> findCodeClarityById(@PathVariable String clarityId) throws Exception {
		CodeClarityResponseDTO codeClarityResponseDTO = clarityMaintainanceService.findCodeClarityById(clarityId);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API creates new clarityMaintainance object
	 * 
	 * @param CodeClarityRequestDTO
	 * @return ResponseEntity<CodeClarityResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CodeClarityResponseDTO> savecodeClarity(
			@RequestBody CodeClarityRequestDTO codesCountryRequestDTO) throws Exception {
		CodeClarityResponseDTO codeClarityResponseDTO = clarityMaintainanceService
				.savecodeClarity(codesCountryRequestDTO);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * This API updates an StoneOrigin object.
	 * 
	 * @param countryCode
	 * @param CodesCountryRequestDTO
	 * @return ResponseEntity<CodeClarityResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{clarityId}")
	public ResponseEntity<CodeClarityResponseDTO> updateclaritymaintainance(@PathVariable String clarityId,
			@RequestBody CodeClarityRequestDTO codeClarityRequestDTO) throws Exception {

		CodeClarityResponseDTO codeClarityResponseDTO = clarityMaintainanceService.updateclaritymaintainance(clarityId,
				codeClarityRequestDTO);
		return ResponseEntity.ok(codeClarityResponseDTO);
	}

	/**
	 * 
	 * @param id
	 * @return CodeClarityResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<CodeClarityResponseDTO> delete(@PathVariable String id) throws Exception {
		CodeClarityResponseDTO responsetDTO = clarityMaintainanceService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodeClarityResponseDTO
	 * @return List<CodeClarityResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodeClarityResponseDTO>> search(
			@RequestBody CodeClarityRequestDTO clarityRequestDTO) throws Exception {
		List<CodeClarityResponseDTO> responsetDTO = clarityMaintainanceService.search(clarityRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
