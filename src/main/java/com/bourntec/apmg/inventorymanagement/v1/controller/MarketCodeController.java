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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.MarketCodeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.MarketCodeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.MarketCodeService;

/**
 * 
 * @author Nince
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/marketcode")
public class MarketCodeController {

	@Autowired
	MarketCodeService marketCodeService;
	/**
	 * This API saves a Market Code
	 * 
	 * @param MarketCodeRequestDTO
	 * 
	 * @return
	 * @throws Exception
	 */
	@PostMapping("")
	public ResponseEntity<MarketCodeResponseDTO> saveMarketCode(
			@RequestBody MarketCodeRequestDTO marketCodeRequestDTO) throws Exception {
		MarketCodeResponseDTO marketCodeResponseDTO = marketCodeService.saveMarketCode(marketCodeRequestDTO);
		return ResponseEntity.ok(marketCodeResponseDTO);
	}

	/**
	 * This API updates a Market Code
	 * 
	 * @param marketCode
	 * @param MarketCodeRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/{marketCode}")
	public ResponseEntity<MarketCodeResponseDTO> updateMarketCode(@PathVariable String marketCode,
			@RequestBody MarketCodeRequestDTO marketCodeRequestdto) throws Exception {
		MarketCodeResponseDTO marketCodeResponseDTO = marketCodeService.updateMarketCode(marketCode, marketCodeRequestdto);
		return ResponseEntity.ok(marketCodeResponseDTO);
	}

	/**
	 * This API fetches Market Code according to {unitCharge}
	 * 
	 * @param marketCode
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/{marketCode}")
	public ResponseEntity<MarketCodeResponseDTO> getById(@PathVariable String marketCode)
			throws Exception {
		MarketCodeResponseDTO marketCodeResponseDTO = marketCodeService.getById(marketCode);
		return ResponseEntity.ok(marketCodeResponseDTO);
	}

	/**
	 * This API fetches all MarketCodes.
	 * 
	 * @return
	 * @throws Exception
	 */
	@GetMapping("")
	public ResponseEntity<List<MarketCodeResponseDTO>> getAll() throws Exception {
		List<MarketCodeResponseDTO> marketCodeResponseList = marketCodeService.getAll();
		return ResponseEntity.ok(marketCodeResponseList);
	}

	/**
	 * REST end point exposes the search interface for searching a Market Code
	 * dynamically
	 * 
	 * @param marketCodeRequestDTO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/search")
	public ResponseEntity<List<MarketCodeResponseDTO>> fetchByMarketCode(
			@RequestBody MarketCodeRequestDTO marketCodeRequestdto) throws Exception {

		List<MarketCodeResponseDTO> marketCodeResponseList = marketCodeService.fetchByMarketCode(marketCodeRequestdto);

		return ResponseEntity.ok(marketCodeResponseList);
	}

	/**
	 * This API delete a Market Code
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<MarketCodeResponseDTO> deleteMarketCode(@PathVariable String marketCode) {
		MarketCodeResponseDTO marketCodeResponse = marketCodeService.deleteMarketCode(marketCode);
		return ResponseEntity.ok(marketCodeResponse);
	}
}
