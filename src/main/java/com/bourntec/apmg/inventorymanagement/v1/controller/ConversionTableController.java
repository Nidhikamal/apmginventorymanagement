package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.inventorymanagement.v1.dto.response.ConversionTableResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.ConversionTableService;

/**
 * 
 * @author Nince
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/conversiontable")
public class ConversionTableController {

	@Autowired
	ConversionTableService conversionTableService;
	

	/**
	 * This API fetches Conversion Table according to {karatValue}
	 * 
	 * @param karatValue
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{karatValue}")
	public ResponseEntity<ConversionTableResponseDTO> getById(@PathVariable String karatValue)
			throws Exception {
		ConversionTableResponseDTO conversionTableResponseDTO = conversionTableService.getById(karatValue);
		return ResponseEntity.ok(conversionTableResponseDTO);
	}

	/**
	 * This API fetches all ConversionTables.
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<ConversionTableResponseDTO>> getAll() throws Exception {
		List<ConversionTableResponseDTO> conversionTableResponseList = conversionTableService.getAll();
		return ResponseEntity.ok(conversionTableResponseList);
	}	
}
