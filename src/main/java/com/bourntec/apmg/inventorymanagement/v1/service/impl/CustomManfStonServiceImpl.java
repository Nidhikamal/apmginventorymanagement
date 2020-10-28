package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomManfStoneResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.CustomManfStoneRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.CustomManfStonService;

@Service(value = "CustomManfStonServiceImpl")
public class CustomManfStonServiceImpl implements CustomManfStonService {

	private static final Logger logger = LogManager.getLogger(CustomManfStonServiceImpl.class);

	@Autowired
	CustomManfStoneRepository customManfStoneRepository;

	/***
	 * 
	 * @Author:Srijini AP-130->AP-239 Inventory Edit unit of measure
	 *                 finished*jewelry-Stones** End point for list all finding of
	 *                 corresponding item**
	 * 
	 * @param itemCode
	 * @return ResponseEntity<List<CustomManfStoneResponseDTO>>
	 */
	@Override
	public List<CustomManfStoneResponseDTO> getItemStones(String itemCode) throws Exception {
		List<CustomManfStoneResponseDTO> customManfStones = new ArrayList<CustomManfStoneResponseDTO>();
		try {
			customManfStones = customManfStoneRepository.getManfStone(itemCode);
			customManfStones.addAll(customManfStoneRepository.getMMStone(itemCode));
			customManfStones.addAll(customManfStoneRepository.getSmalltone(itemCode));

		} catch (Exception e) {
			logger.error("Exception while getItemStones : " + e.getMessage());
			throw e;
		}
		return customManfStones;
	}

}
