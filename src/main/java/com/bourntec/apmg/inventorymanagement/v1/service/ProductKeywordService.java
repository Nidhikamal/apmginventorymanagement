package com.bourntec.apmg.inventorymanagement.v1.service;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.ProductKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.ProductKeywordsResponseDTO;

public interface ProductKeywordService {

	ProductKeywordsResponseDTO saveProductKeywords(ProductKeywordRequestDTO productKeywordRequestDTO) throws Exception;


}
