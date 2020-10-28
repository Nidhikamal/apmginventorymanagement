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

import com.bourntec.apmg.inventorymanagement.v1.dto.request.InvStyleNameRequestDTO;
import com.bourntec.apmg.inventorymanagement.v1.dto.response.InvStyleNameResponseDTO;
import com.bourntec.apmg.inventorymanagement.v1.service.InvStyleNameService;

/**
 * @author vidya.p
 *
 */
@RestController(value = "InvStyleNameController")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/inventorymanagement/v1/stylename")
public class InvStyleNameController {

	@Autowired
	InvStyleNameService invStyleNameService;
	/**
	 * @Author:Vidya.p This REST endpoint for saveStyleNameResponse
	 * @param InvStyleNameRequestDTO
	 * @return ResponseEntity<InvStyleNameResponseDTO> 
	 */
	  @PostMapping("") 
	  public ResponseEntity<InvStyleNameResponseDTO> saveStyleNameResponse(@RequestBody InvStyleNameRequestDTO reqDTO) throws Exception
	  {
		  InvStyleNameResponseDTO respDTO =invStyleNameService.saveStyleName(reqDTO);
		  return ResponseEntity.ok(respDTO);
	  
	  }
	  /**
		 * This API updateStyleName
		 * @param styleId
		 * @return ResponseEntity<InvStyleNameResponseDTO>
		 * @throws Exception 
		 */
	  @PutMapping("/{styleId}")
		public ResponseEntity<InvStyleNameResponseDTO> updateStyleName(@RequestBody InvStyleNameRequestDTO reqDTO,
				@PathVariable String styleId) throws Exception {

		  InvStyleNameResponseDTO styleNameResponseDTO = invStyleNameService.updateStyleName(reqDTO,
				  styleId);
			return ResponseEntity.ok(styleNameResponseDTO);
		}
	  
	  /**
		 * This API get  StyleName by
		 * @param style Id
		 * @return ResponseEntity<VendorDataResponseDTO>
		 * @throws Exception 
		 */
		@GetMapping("/{styleId}")
		public ResponseEntity<InvStyleNameResponseDTO> getStyleNameById(@PathVariable String styleId)
				throws Exception {

			InvStyleNameResponseDTO invStyleNameResponseDTO = invStyleNameService.getStyleNameById(styleId);
			return ResponseEntity.ok(invStyleNameResponseDTO);
		}
		
		/**
		 * This API get  all stylename
		 * @return ResponseEntity<InvStyleNameResponseDTO>
		 * @throws Exception 
		 */
		
		@GetMapping("")
		public ResponseEntity<List<InvStyleNameResponseDTO>> findAllInvStyleName() throws Exception{
			List<InvStyleNameResponseDTO> invStyleNameResponseDTO= invStyleNameService.findAllinvStyleName();
			return ResponseEntity.ok(invStyleNameResponseDTO);
		}
		
		/**
		 * This API   delete stylename
		 * @return ResponseEntity<InvStyleNameResponseDTO>
		 * @throws Exception 
		 */
		
		/**
		 * This API delete a Customer Employee
		 * 
		 * @param styleId
		 * @return
		 */
		@DeleteMapping("/{styleId}")
		public ResponseEntity<?> deleteStylename(@PathVariable String styleId)throws Exception {
			invStyleNameService.deleteStyleName(styleId);
			return ResponseEntity.ok().build();
		}
}
