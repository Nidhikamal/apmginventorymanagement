package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.MarketCodeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.MarketCodeResponseDTO;

public interface MarketCodeService {
	/**
	 * Service method that persist Market Code to the DB
	 * 
	 * @param MarketCodeRequestDTO
	 * @return
	 */
	MarketCodeResponseDTO saveMarketCode(MarketCodeRequestDTO marketCodeRequestDTO);
	
	/**
	 * Method that updates Market Code object in DB
	 * 
	 * @param marketCode
	 * @param marketCodeRequestDTO
	 * @return
	 */
	MarketCodeResponseDTO updateMarketCode(String marketCode,
			MarketCodeRequestDTO marketCodeRequestDTO);
	/**
	 * Method that fetches Inv Unit Charge according to
	 * 
	 * @param unitCharge
	 * @return
	 */
	MarketCodeResponseDTO getById(String marketCode);
	/**
	 * Handles the fetching of all the Market Code in DB
	 * 
	 * @return
	 */
	List<MarketCodeResponseDTO> getAll();
	
	/**
	 * Fetches a Market Code object based on a criteria object
	 * 
	 * @param marketCodeRequestDTO
	 * @return
	 */
	List<MarketCodeResponseDTO> fetchByMarketCode(MarketCodeRequestDTO marketCodeRequestDT) throws Exception;
	/**
	 * Deletes a Market Code object from the DB based on
	 * 
	 * @param id
	 * @return 
	 */
	MarketCodeResponseDTO deleteMarketCode(String marketCode);}
