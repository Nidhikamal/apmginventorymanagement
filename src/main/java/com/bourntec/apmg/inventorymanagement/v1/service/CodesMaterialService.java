package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodesColor;
import com.bourntec.apmg.entity.CodesMaterial;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesColorRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesMaterailRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesColorResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesMaterialResponseDTO;

public interface CodesMaterialService {
	CodesMaterialResponseDTO findMaterialCodesById(String id);

	List<CodesMaterial> findAllMaterialCodes();

	CodesMaterialResponseDTO updateMaterialCodesById(String id, CodesMaterailRequestDTO codesMaterialReqDTO);

	CodesMaterialResponseDTO saveMaterialCodes(CodesMaterailRequestDTO codesMaterialReqDTO);

	CodesMaterialResponseDTO delete(String id);

	List<CodesMaterialResponseDTO> search(CodesMaterailRequestDTO requestDTO);
}
