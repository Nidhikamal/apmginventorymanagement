package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.response.ConversionTableResponseDTO;

public interface ConversionTableService {
	
	/**
	 * Method that fetches Conversion Table according to
	 * 
	 * @param unitCharge
	 * @return
	 */
	ConversionTableResponseDTO getById(String karatValue);
	/**
	 * Handles the fetching of all the Conversion Table in DB
	 * 
	 * @return
	 */
	List<ConversionTableResponseDTO> getAll();
	
}
