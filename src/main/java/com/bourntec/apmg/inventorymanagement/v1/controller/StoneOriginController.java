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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.StoneOriginService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/stoneorigin")
public class StoneOriginController {

	@Autowired
	StoneOriginService stoneOriginService;

	/**
	 * This API fetches all StoneOriginDetails.
	 * 
	 * @return <List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<CodesCountryResponseDTO>> findAllCodesCountry() throws Exception {
		List<CodesCountryResponseDTO> codesCountryResponsetDTODTOList = stoneOriginService.findAllCodesCountry();
		return ResponseEntity.ok(codesCountryResponsetDTODTOList);
	}

	/**
	 * This API fetches StoneOrigin object.
	 * 
	 * @param countryCode
	 * @return ResponseEntity<CountrycodeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{countryCode}")
	public ResponseEntity<CodesCountryResponseDTO> findcodeCountryById(@PathVariable String countryCode)
			throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = stoneOriginService.findcodeCountryById(countryCode);
		return ResponseEntity.ok(codesCountryResponsetDTO);
	}

	/**
	 * This API creates new StoneOrigin object
	 * 
	 * @param CountryRequestDTO
	 * @return ResponseEntity<CodesCountryResponsetDTO>
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<CodesCountryResponseDTO> savecodeCountry(
			@RequestBody CodesCountryRequestDTO codesCountryRequestDTO) throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = stoneOriginService.savecodeCountry(codesCountryRequestDTO);
		return ResponseEntity.ok(codesCountryResponsetDTO);
	}

	/**
	 * This API updates an StoneOrigin object.
	 * 
	 * @param countryCode
	 * @param CodesCountryRequestDTO
	 * @return ResponseEntity<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PutMapping("/{countryCode}")
	public ResponseEntity<CodesCountryResponseDTO> updateStoneOrigin(@PathVariable String countryCode,
			@RequestBody CodesCountryRequestDTO codesCountryRequestDTO) throws Exception {
		CodesCountryResponseDTO codesCountryResponsetDTO = stoneOriginService.updateStoneOrigin(countryCode,
				codesCountryRequestDTO);
		return ResponseEntity.ok(codesCountryResponsetDTO);
	}

	/**
	 * This API delete an StoneOrigin object.
	 * 
	 * @param id
	 * @return CodesCountryResponsetDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<CodesCountryResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CodesCountryResponseDTO responsetDTO = stoneOriginService.delete(id);
		return ResponseEntity.ok(responsetDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodesShapeRequestDTO
	 * @return List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodesCountryResponseDTO>> searchShapeMaintance(
			@RequestBody CodesCountryRequestDTO shapeRequestDTO) throws Exception {
		List<CodesCountryResponseDTO> responsetDTO = stoneOriginService.search(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
}
