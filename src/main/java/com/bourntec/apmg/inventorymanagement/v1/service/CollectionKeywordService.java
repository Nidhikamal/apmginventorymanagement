package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CollectionKeyword;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionKeywordResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;

public interface CollectionKeywordService {

	CollectionKeywordResponseDTO findCollectionKeywordById(String id) throws Exception;

	List<CollectionKeyword> findAllCollectionKeywords() throws Exception;

	CollectionKeywordResponseDTO updateCollectionKeywordsById(String id, CollectionKeywordRequestDTO keywordReqDTO)
			throws Exception;

	CollectionKeywordResponseDTO saveCollectionKeywords(CollectionKeywordRequestDTO keywordReqDTO) throws Exception;

	CollectionKeywordResponseDTO delete(String id) throws Exception;

	List<CollectionKeywordResponseDTO> search(CollectionKeywordRequestDTO shapeRequestDTO) throws Exception;

}
