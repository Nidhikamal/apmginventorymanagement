package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.InventoryCategory;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.InventoryCategoryRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvCategoryResponseDTO;

public interface InvCategoryService {

	InvCategoryResponseDTO findInvCategoryById(String id);

	List<InventoryCategory> findAllInvCategories();

	InvCategoryResponseDTO updateInvCategoryById(String id, InventoryCategoryRequestDTO invCatReqDTO);

	InvCategoryResponseDTO saveInvCategories(InventoryCategoryRequestDTO invCatReqDTO);

	List<InvCategoryResponseDTO> search(InventoryCategoryRequestDTO requestDTO) throws Exception;

	InvCategoryResponseDTO delete(String id);

}
