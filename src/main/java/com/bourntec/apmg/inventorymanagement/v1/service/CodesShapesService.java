package com.bourntec.apmg.inventorymanagement.v1.service;

import java.util.List;

import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesShapeResponseDTO;

public interface CodesShapesService {

	List<CodesShapeResponseDTO> findAllShapeId() throws Exception;

	CodesShapeResponseDTO findShapecodeById(String shapeId) throws Exception;

	CodesShapeResponseDTO saveCodeShape(CodesShapeRequestDTO codeShapeRequestDTO) throws Exception;

	CodesShapeResponseDTO updateShapeMaintainance(String shapeId, CodesShapeRequestDTO codeShapeRequestDTO)  throws Exception;

	CodesShapeResponseDTO deleteShapeMaintance(String id)  throws Exception;

	List<CodesShapes> searchShapeMaintance(CodesShapeRequestDTO shapeRequestDTO) throws Exception;

}
