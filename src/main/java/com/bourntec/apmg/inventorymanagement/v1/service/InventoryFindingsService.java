package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryFindingsRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryFindingsResponseDTO;

public interface InventoryFindingsService {

	List<InventoryFindingsResponseDTO> getItemFindings(String itemCode) throws Exception;

	List<InventoryFindingsResponseDTO> saveFindings(List<InventoryFindingsRequestDTO> invReqDTO) throws Exception;

}
