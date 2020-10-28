package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvStyleNameRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvStyleNameResponseDTO;

public interface InvStyleNameService {

	InvStyleNameResponseDTO updateStyleName(InvStyleNameRequestDTO reqDTO, String styleId) throws Exception; ;

	InvStyleNameResponseDTO getStyleNameById(String styleId) throws Exception;
 
	List<InvStyleNameResponseDTO> findAllinvStyleName() throws Exception;

	InvStyleNameResponseDTO saveStyleName(InvStyleNameRequestDTO reqDTO) throws Exception;

	void deleteStyleName(String styleId) throws Exception;
	
	 
	 
	
}
