package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CountryCodes;
import com.bourntec.apmg.entity.VendorItemMatch;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.VendorItemMatchRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.VendorItemMatchResponseDTO;

public interface VendorItemMatchService {

	VendorItemMatchResponseDTO saveInvetoryData(List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO) throws Exception;

	VendorItemMatchResponseDTO updateVendorItemMatch(List<VendorItemMatchRequestDTO> lstvendorItemMatchRequestDTO,String itemCode) throws Exception;

	List<VendorItemMatch> fetchAllVendorItemMatchByItemcode(String itemCode);
}
