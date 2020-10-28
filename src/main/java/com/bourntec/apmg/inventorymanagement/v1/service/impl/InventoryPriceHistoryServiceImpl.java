package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.InventoryPriceHistory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryPriceHistoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InventoryPriceHistoryResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.InventoryPriceHistoryRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.InventoryPriceHistoryService;

@Service
public class InventoryPriceHistoryServiceImpl implements InventoryPriceHistoryService {
	private static final Logger logger = LogManager.getLogger(InventoryPriceHistoryServiceImpl.class);
	@Autowired
	InventoryPriceHistoryRepository invPriceRepo;

	/**
	 * @author amal This is the main method which is used to get price history of
	 *         price
	 * @return Inventory1ResponseDTO
	 */
	public List<InventoryPriceHistory> getAllPriceHistoryofItem(String itemCode) throws Exception {
		InventoryPriceHistory invPrice = new InventoryPriceHistory();
		List<InventoryPriceHistory> inventoryPriceHistoryList = new ArrayList<InventoryPriceHistory>();
		try {
			invPrice.setItemCode(itemCode);

			inventoryPriceHistoryList = invPriceRepo.findAll(Example.of(invPrice));
		} catch (Exception e) {
			logger.error("Error at getAllPriceHistoryofItem: " + e);
		}
		return inventoryPriceHistoryList;
	}

	@Override
	public InventoryPriceHistoryResponseDTO saveInvetoryPrice(InventoryPriceHistoryRequestDTO invPricehistory)
			throws Exception {
		InventoryPriceHistoryResponseDTO historyResponseDTO = new InventoryPriceHistoryResponseDTO();
		try {
			InventoryPriceHistory inventoryPriceHistory = invPricehistory.tomodel(invPricehistory);
			inventoryPriceHistory = invPriceRepo.save(inventoryPriceHistory);
			BeanUtils.copyProperties(inventoryPriceHistory, historyResponseDTO);
		} catch (BeansException e) {
			logger.error("Error at saveInvetoryPrice: " + e);
			
		}
		return historyResponseDTO;
	}

}
