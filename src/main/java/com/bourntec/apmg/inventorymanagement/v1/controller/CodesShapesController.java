package com.bourntec.apmg.inventorymanagement.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bourntec.apmg.entity.CodesShapes;
import com.bourntec.apmg.inventorymanagement.v1.dto.request.CodesShapeRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.CodesShapeResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.CodesShapesService;

/**
 * AP 301 - Inventory Refactoring
 * @author Srijini
 *
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/shapemaintainance")
public class CodesShapesController {

	@Autowired
	CodesShapesService codesShapesService;

	/**
	 * This API finAll new ShapeMaintainance object
	 * 
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("")
	public ResponseEntity<List<CodesShapeResponseDTO>> findAllShapeCode() throws Exception {
		List<CodesShapeResponseDTO> codeShapeResponseDTOList = codesShapesService.findAllShapeId();
		return ResponseEntity.ok(codeShapeResponseDTOList);
	}

	/**
	 * This API fetches ShapeMaintainance object.
	 * 
	 * @param shapeId
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@GetMapping("/{shapeId}")
	public ResponseEntity<CodesShapeResponseDTO> findShapecodeById(@PathVariable String shapeId) throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = codesShapesService.findShapecodeById(shapeId);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API creates new ShapeMaintainance object
	 * 
	 * @param CodesShapeRequestDTO
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@PostMapping("")
	public ResponseEntity<CodesShapeResponseDTO> saveCodeShape(@RequestBody CodesShapeRequestDTO codeShapeRequestDTO)
			throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = codesShapesService.saveCodeShape(codeShapeRequestDTO);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API updates an CodeShapeMaintainanceshape object.
	 * 
	 * @param id
	 * @param CodesShapeRequestDTO
	 * @return ResponseEntity<CodeShapeResponseDTO>
	 * @throws Exception
	 */

	@PutMapping("/{shapeId}")
	public ResponseEntity<CodesShapeResponseDTO> updateShapeMaintainance(@PathVariable String shapeId,
			@RequestBody CodesShapeRequestDTO codeShapeRequestDTO) throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = codesShapesService.updateShapeMaintainance(shapeId,
				codeShapeRequestDTO);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API delete an ShapeMaintance object.
	 * 
	 * @param id
	 * @return CodeShapeResponseDTO
	 * @throws Exception
	 */

	@DeleteMapping("/{id}")
	public ResponseEntity<CodesShapeResponseDTO> deleteShapeMaintance(@PathVariable String id) throws Exception {
		CodesShapeResponseDTO codeShapeResponseDTO = codesShapesService.deleteShapeMaintance(id);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

	/**
	 * This API search on ShapeMaintance object.
	 * 
	 * @param CodesShapeRequestDTO
	 * @return List<CodeShapeRequestDTO>
	 * @throws Exception
	 */

	@PostMapping("/search")
	public ResponseEntity<List<CodesShapes>> searchShapeMaintance(
			@RequestBody CodesShapeRequestDTO shapeRequestDTO) throws Exception {
		List<CodesShapes> codeShapeResponseDTO = codesShapesService.searchShapeMaintance(shapeRequestDTO);
		return ResponseEntity.ok(codeShapeResponseDTO);
	}

}
