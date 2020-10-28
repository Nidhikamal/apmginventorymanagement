package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.CodesShapes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodesShapeRequestDTO {

	private String shapeId;
	private String shapeName;

	public CodesShapes toModel(CodesShapeRequestDTO codeShapeRequestDTO) {

		CodesShapes codeShapes = new CodesShapes();
		codeShapes.setShapeId(codeShapeRequestDTO.getShapeId());
		codeShapes.setShapeName(codeShapeRequestDTO.getShapeName());
		return codeShapes;
	}

}
