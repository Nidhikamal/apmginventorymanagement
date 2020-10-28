package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.Inventory1;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.Inventory1ResponseDTO;

public interface Inventory1Service {

	//List<Inventory1ResponseDTO> inventoryOrderSearch(Inventory1RequestDTO inventory1RequestDTO, int page, int size) throws Exception;

	List<Inventory1> inventory1Search(Inventory1RequestDTO inventory1) throws Exception;
	Inventory1ResponseDTO saveInvetoryData(Inventory1RequestDTO invReqDTO) throws Exception;

	Inventory1 findByInvItemId(String invId) throws Exception;

	Inventory1ResponseDTO updateInv(String invId, Inventory1RequestDTO reqDTO) throws Exception;

}
