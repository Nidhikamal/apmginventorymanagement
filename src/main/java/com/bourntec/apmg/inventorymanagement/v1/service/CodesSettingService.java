package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesSettingRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesSettingResponseDTO;

public interface CodesSettingService {
	CodesSettingResponseDTO savecodeSetting(CodesSettingRequestDTO codeSettingRequestDTO) throws Exception;

	CodesSettingResponseDTO findBycodeSetting(String settingId) throws Exception;

	List<CodesSettingResponseDTO> findAllCodeSettings() throws Exception;

	CodesSettingResponseDTO updatecodeSetting(String settingId, CodesSettingRequestDTO codeSettingRequestDTO)
			throws Exception;

	CodesSettingResponseDTO delete(String id) throws Exception;

	public List<CodesSettingResponseDTO> search(CodesSettingRequestDTO codesSettingRequestDTO) throws Exception;
}
