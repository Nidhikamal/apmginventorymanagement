package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.inventorymanagement.v1.dto.response.CustomManfStoneResponseDTO;

public interface CustomManfStonService {

	List<CustomManfStoneResponseDTO> getItemStones(String itemCode) throws Exception;
}
