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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesCountryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesCountryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesCountryService;
/**
 * Controller for CodesCountry
 * @author NInce
 *
 */
@RestController(value = "CodesCountryController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/manufacturemanagement/v1/codescountry")
public class CodesCountryController {

	@Autowired
	CodesCountryService codesCountryService;

	/**
	 * This REST end point exposes the search interface for returning all Codes Country
	 * details
	 * 
	 */
	@GetMapping("")
	public ResponseEntity<List<CodesCountryResponseDTO>> fetchAllData() throws Exception {

		List<CodesCountryResponseDTO> allData = codesCountryService.findAllCodesCountry();
		return ResponseEntity.ok(allData);
	}

	/**
	 * This REST end point exposes the search interface for returning Codes Country
	 * keyword by countryCode
	 * 
	 */

	@GetMapping("/{countryCode}")
	public ResponseEntity<CodesCountryResponseDTO> getCodesCountryById(@PathVariable String countryCode)
			throws Exception {

		CodesCountryResponseDTO codesCountryKeyword = codesCountryService
				.getCodesCountryByCountryCode(countryCode);

		return ResponseEntity.ok(codesCountryKeyword);
	}

	/**
	 * This REST end point for saving CodesCountry
	 * 
	 */

	@PostMapping("")
	public ResponseEntity<CodesCountryResponseDTO> saveCodesCountry(
			@RequestBody CodesCountryRequestDTO codesCountryReq) throws Exception {

		CodesCountryResponseDTO savedrespData = codesCountryService.saveCodesCountry(codesCountryReq);

		return ResponseEntity.ok(savedrespData);

	}

	/**
	 * This REST end point for updating CodesCountry by countryCode
	 * 
	 */

	@PutMapping("/{countryCode}")
	public ResponseEntity<CodesCountryResponseDTO> updateCodesCountry(
			@RequestBody CodesCountryRequestDTO codesCountryReq, @PathVariable String countryCode) throws Exception {

		CodesCountryResponseDTO updatedrespData = codesCountryService.updateCodesCountry(countryCode,
				codesCountryReq);
		return ResponseEntity.ok(updatedrespData);
	}

	/**
	 * This REST end point exposes the search interface for searching
	 * CodesCountry
	 */
	@PostMapping("/search")
	public ResponseEntity<List<CodesCountryResponseDTO>> findCodesCountryByCriteria(
			@RequestBody CodesCountryRequestDTO codesCountryReq) throws Exception {

		List<CodesCountryResponseDTO> selectedCodesCountry = codesCountryService
				.findCodesCountryByCriteria(codesCountryReq);

		return ResponseEntity.ok(selectedCodesCountry);
	}

	/**
	 * This REST end point exposes the delete CodesCountry by countryCode
	 * 
	 * @param countryCode
	 * @return
	 */
	@DeleteMapping("/{countryCode}")
	private ResponseEntity<CodesCountryResponseDTO> deleteCodesCountryByCountryCode(@PathVariable("id") String countryCode) {
		CodesCountryResponseDTO codesCountryResponseDTO = codesCountryService
				.deleteCodesCountryByCountryCode(countryCode);
		return ResponseEntity.ok(codesCountryResponseDTO);
	}
}
