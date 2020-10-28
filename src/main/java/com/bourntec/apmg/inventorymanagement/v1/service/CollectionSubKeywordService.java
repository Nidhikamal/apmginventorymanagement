package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CollectionSubKeywordRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CollectionSubKeywordResponseDTO;

public interface CollectionSubKeywordService {

	CollectionSubKeywordResponseDTO saveCollectionSubKeywords(
			CollectionSubKeywordRequestDTO subKeywordRequestDTOs) throws Exception;

	CollectionSubKeywordResponseDTO updateSubKey(String subKeyId,
			CollectionSubKeywordRequestDTO subKeywordRequestDTOs) throws Exception;

	List<CollectionSubKeywordResponseDTO> getAll();

	CollectionSubKeywordResponseDTO getById(String subKeyId);

	List<CollectionSubKeywordResponseDTO> search(CollectionSubKeywordRequestDTO subKeywordRequestDTOs, int page,
			int size);

}
