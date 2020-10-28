package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodeClasp;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodeClaspRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodeClaspResponsetDTO;

public interface CodeClaspService {

	List<CodeClaspResponsetDTO> findAllodeClasp() throws Exception;

	CodeClaspResponsetDTO findByclaspId(String claspId) throws Exception;

	CodeClaspResponsetDTO savecodeClasp(CodeClaspRequestDTO codeClaspRequestDTO) throws Exception;

	CodeClaspResponsetDTO updatecodeclasp(String claspId, CodeClaspRequestDTO codeClaspRequestDTO) throws Exception;

	CodeClaspResponsetDTO delete(String id) throws Exception;

	List<CodeClasp> search(CodeClaspRequestDTO claspRequestDTO) throws Exception;

}
