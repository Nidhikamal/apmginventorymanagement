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

import com.bourntec.apmg.entity.CountrySetup;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CountrySetupRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CountrySetupResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CountrySetupService;

/**
 * AP 301 - Inventory Refactoring
 * 
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/countrysetup")
public class CountrySetupController {

	@Autowired
	CountrySetupService countrySetupService;

	@GetMapping("")
	public ResponseEntity<List<CountrySetup>> fetchAllCountrySetups() throws Exception {

		List<CountrySetup> allCountrySetups = countrySetupService.findCountrySetup();
		return ResponseEntity.ok(allCountrySetups);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for returning
	 *          countrySetup by id
	 * @param countryCode
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@GetMapping("/{countryCode}")
	public ResponseEntity<CountrySetupResponseDTO> fetchByCountryId(@PathVariable String countryCode) throws Exception {

		CountrySetupResponseDTO selectedCountryCodes = countrySetupService.findCountrySetupById(countryCode);

		return ResponseEntity.ok(selectedCountryCodes);
	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for saving
	 *          countrySetUps
	 * @param CountrySetupRequestDTO
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PostMapping("")
	public ResponseEntity<CountrySetupResponseDTO> saveCountrySetup(
			@RequestBody CountrySetupRequestDTO countrySetupReqDTO) throws Exception {

		CountrySetupResponseDTO savedCountryRespDTO = countrySetupService.saveCountrySetup(countrySetupReqDTO);

		return ResponseEntity.ok(savedCountryRespDTO);

	}

	/**
	 * @Author: Amal This REST endpoint exposes the search interface for updating
	 *          countrySet up by Id
	 * @param CountrySetupRequestDTO,countryId
	 * @return ResponseEntity<CountrySetupResponseDTO>
	 */

	@PutMapping("/{countryCode}")
	public ResponseEntity<Object> updateCountrySetup(@RequestBody CountrySetupRequestDTO countrySetupReqDTO,
			@PathVariable String countryCode) throws Exception {

		CountrySetupResponseDTO updatedCountrySetupResDTO = countrySetupService.updateCountrySetupById(countryCode,
				countrySetupReqDTO);
		return ResponseEntity.ok(updatedCountrySetupResDTO);
	}

	/**
	 * @return CountrySetupResponseDTO
	 * @throws Exception
	 */
	
	@DeleteMapping("/{id}")
	private ResponseEntity<CountrySetupResponseDTO> deleteShapeMaintance(@PathVariable("id") String id) {
		CountrySetupResponseDTO CountrySetupResponseDTO = countrySetupService.delete(id);
		return ResponseEntity.ok(CountrySetupResponseDTO);
	}

	/**
	 * This API search on StoneOrigin object.
	 * 
	 * @param CodesShapeRequestDTO
	 * @return List<CodesCountryResponsetDTO>
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CountrySetupResponseDTO>> searchShapeMaintance(
			@RequestBody CountrySetupRequestDTO shapeRequestDTO) throws Exception {
		List<CountrySetupResponseDTO> responsetDTO = countrySetupService.search(shapeRequestDTO);
		return ResponseEntity.ok(responsetDTO);
	}
	
}
