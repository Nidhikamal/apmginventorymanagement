package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.LockingTypeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LockingTypeResponseDTO;

public interface LockingTypeService {

	LockingTypeResponseDTO findLockingTypesById(Long lockingTypeId);

	List<LockingTypeResponseDTO> findAllLockingTypes();

	LockingTypeResponseDTO saveLockingTypes(LockingTypeRequestDTO lockingTypesRequestDTO);
	
	LockingTypeResponseDTO updateLockingType(Long id, LockingTypeRequestDTO lockingTypeRequestDTO);

	LockingTypeResponseDTO deleteLockingType(Long id);

	List<LockingTypeResponseDTO> searchLockingType(LockingTypeRequestDTO lockingTypeRequestDTO) throws Exception;;

}
