package com.bourntec.apmg.inventorymanagement.v1.dto.response; 
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.inventorymanagement.v1.dto.request.Inventory1RequestDTO;

import lombok.Getter;
import lombok.Setter;

/**
 * Response dto for InvWeightResponseDTO
 * @author Vidya.p
 *
 */
@Getter
@Setter
@Validated

public class InventoryLibraryResponseDTO{
	private Long Id;
	
	private String style;

	private String itemCode;

	private String jobNo;

	private String smallImage;

	private String largeImage;

	private Double total;

	private Double markUp;

	private Double size;

	private String webyn;

	private String subCategory;

	private String location;

	private String videoFile;

	private String specification;

	private Double retialPrice;

	private String variantSize;

	private Double variantCost;

	private Double materialCost;

	private Double stoneCost;

	private Double retailMarkUp;

	private Double laborCost;

	private String labor;

	private String description;
	
	private Double leadTime;

	private String displayOnApollo;

	private Date createdDate;

	private String retailImage;
	
	private String responseMessage;
	
	
}
