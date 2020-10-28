package com.bourntec.apmg.inventorymanagement.v1.service;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.CustomInventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomInventory1ResponseDTO;

public interface CustomInventory1Service {

	CustomInventory1ResponseDTO getPriceandWeightfromKarat(CustomInventory1RequestDTO invReqDTO) throws Exception;

	CustomInventory1ResponseDTO getPricefromWeight(CustomInventory1RequestDTO invReqDTO) throws Exception;

	CustomInventory1ResponseDTO getPricefromItemCost(CustomInventory1RequestDTO invReqDTO) throws Exception;

	CustomInventory1ResponseDTO getPricefromSalesPrice(CustomInventory1RequestDTO invReqDTO) throws Exception;

}
