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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.LockingTypeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.LockingTypeService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/lockingtype")
public class LockingTypeController {

	@Autowired
	LockingTypeService lockingTypeService;

	/**
	 * This API fetch all LockingType.
	 * 
	 * @return<List<LockingTypeResponseDTO>>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<LockingTypeResponseDTO>> findAllLockingTypes() throws Exception {
		List<LockingTypeResponseDTO> lockingTypesResponseDTOList = lockingTypeService.findAllLockingTypes();
		return ResponseEntity.ok(lockingTypesResponseDTOList);
	}

	/**
	 * This API fetches LockType object.
	 * 
	 * @param lockingTypeId
	 * @return ResponseEntity<LockingTypeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{lockingTypeId}")
	public ResponseEntity<LockingTypeResponseDTO> findLockingTypeById(@PathVariable Long lockingTypeId)
			throws Exception {
		LockingTypeResponseDTO LockingTypesResponseDTO = lockingTypeService.findLockingTypesById(lockingTypeId);
		return ResponseEntity.ok(LockingTypesResponseDTO);
	}

	/**
	 * This API creates new LockType object
	 * 
	 * @param LockingTypeRequestDTO
	 * @return ResponseEntity<LockingTypeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<LockingTypeResponseDTO> saveLockingTypes(
			@RequestBody LockingTypeRequestDTO lockingTypesRequestDTO) throws Exception {
		LockingTypeResponseDTO LockingTypesResponseDTO = lockingTypeService.saveLockingTypes(lockingTypesRequestDTO);
		return ResponseEntity.ok(LockingTypesResponseDTO);
	}

	/**
	 * This API updtes an LockType object.
	 * 
	 * @param id
	 * @param LockingTypeRequestDTO
	 * @return ResponseEntity<LockingTypeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{id}")
	public ResponseEntity<LockingTypeResponseDTO> updateLockingType(@PathVariable Long id,
			@RequestBody LockingTypeRequestDTO lockingTypeRequestDTO) throws Exception {
		LockingTypeResponseDTO lockingTypeResponseDTO = lockingTypeService.updateLockingType(id, lockingTypeRequestDTO);
		return ResponseEntity.ok(lockingTypeResponseDTO);
	}

	/**
	 * This API delete an LockType object.
	 * 
	 * @param id
	 * @return LockingTypeResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<LockingTypeResponseDTO> deleteLockingType(@PathVariable Long id) throws Exception {
		LockingTypeResponseDTO lockingTypeResponseDTO = lockingTypeService.deleteLockingType(id);
		return ResponseEntity.ok(lockingTypeResponseDTO);
	}

	/**
	 * This API search on LockType object.
	 * @param lockingTypeRequestDTO
	 * @return
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<LockingTypeResponseDTO>> searchLockingType(
			@RequestBody LockingTypeRequestDTO lockingTypeRequestDTO) throws Exception {
		List<LockingTypeResponseDTO> lockingTypeResponseDTO = lockingTypeService.searchLockingType(lockingTypeRequestDTO);
		return ResponseEntity.ok(lockingTypeResponseDTO);
	}

}
