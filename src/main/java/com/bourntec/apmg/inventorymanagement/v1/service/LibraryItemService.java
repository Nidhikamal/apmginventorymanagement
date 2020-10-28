package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.LibraryItemRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.LibraryItemResponseDTO;

public interface LibraryItemService {
	
	 
	 LibraryItemResponseDTO saveLibraryItem(List<LibraryItemRequestDTO> reqDTO) throws Exception;
	 LibraryItemResponseDTO updateLibraryItem(List<LibraryItemRequestDTO> reqDTO,String itemCode) throws Exception;
	 List<LibraryItemResponseDTO> getLibraryItemById(String itemId);
	 byte[] readActualImage(int libId);
}
