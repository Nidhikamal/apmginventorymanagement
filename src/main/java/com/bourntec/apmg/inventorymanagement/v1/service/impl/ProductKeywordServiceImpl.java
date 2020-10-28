package com.bourntec.apmg.inventorymanagement.v1.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bourntec.apmg.entity.ProductKeywords;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.ProductKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.ProductKeywordsResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.repository.ProductKeywordsRepository;
import com.bourntec.apmg.inventorymanagement.v1.service.ProductKeywordService;
@Service
public class ProductKeywordServiceImpl implements ProductKeywordService {
	private static final Logger logger = LogManager.getLogger(ProductKeywordServiceImpl.class);

	@Autowired
	ProductKeywordsRepository productKeywordsRepository;

	@Override
	public ProductKeywordsResponseDTO saveProductKeywords(ProductKeywordRequestDTO productKeywordRequestDTO)
			throws Exception {
		ProductKeywordsResponseDTO productKeywordsResponseDTO = new ProductKeywordsResponseDTO();
		try {
			ProductKeywords productKeywords = productKeywordRequestDTO.toModel(productKeywordRequestDTO);
			ProductKeywords productKeywordsEntity = productKeywordsRepository.save(productKeywords);
			if (productKeywordsEntity != null) {
				BeanUtils.copyProperties(productKeywordsEntity, productKeywordsResponseDTO);
				logger.info(" Product Keywords saved successfully");
			} else {
				logger.error("Failed to save  Product Keywords ");
			}
		} catch (Exception e) {
			logger.error("Save:  Product Keywords Data  error " + e);
			throw e;
		}

		return productKeywordsResponseDTO;
	}

}
