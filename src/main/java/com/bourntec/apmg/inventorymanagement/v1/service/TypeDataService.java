package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.TypeData;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.TypeDataRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.TypeDataResponseDTO;

public interface TypeDataService {

	TypeDataResponseDTO findTypeDataById(String id) throws Exception;

	List<TypeData> findAllTypeDatas() throws Exception;

	TypeDataResponseDTO updateTypeDataById(String id, TypeDataRequestDTO typeDataReqDTO) throws Exception;

	TypeDataResponseDTO saveTypeData(TypeDataRequestDTO typeDataReqDTO) throws Exception;

	TypeDataResponseDTO delete(String id) throws Exception;

	List<TypeDataResponseDTO> search(TypeDataRequestDTO shapeRequestDTO) throws Exception;

}
