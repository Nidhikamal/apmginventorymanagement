/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter
public class TNumberResponseDTO {

	private Long tno;

	private String category;

	private String styleCreateyn;

	private String styleNo;

	private String designerId;

	private String status;

	private String cadId;

	private String custNo;

	private String cadId1;

	private String renderId;

	private Date tdate;

	private Date endDate;

	private Date cadDate;

	private Date designDate;

	private Date cadDate1;

	private Date renderDate;

//	private String tdate;
//
//	private String endDate;
//
//	private String cadDate;
//
//	private String designDate;
//
//	private String cadDate1;
//
//	private String renderDate;

	private Long brandId;

	private String notes;

	private String designerNote;

	private String cadNote;

	private String cadNote1;

	private String renderNote;

	private String responseMessage;

}
