/**
 * 
 */
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.Date;

import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.TNumber;
import com.bourntec.apmg.inventorymanagement.v1.utils.DateUtils;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Validated
@Getter
@Setter
public class TNumberRequestDTO {

	private Long tno;

	private String category;

	@Size(max = 5, message = "Style Create must be atmost 5 characters")
	private String styleCreateyn;

	private String styleNo;

	private String designerId;

	@Size(max = 1, message = "status must be 1 characters")
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

//	private byte[] notes;
//
//	private byte[] designerNote;
//
//	private byte[] cadNote;
//
//	private byte[] cadNote1;
//
//	private byte[] renderNote;

	public TNumber toModel(TNumberRequestDTO numberRequestDTO) {
		TNumber tNumber = new TNumber();
		try {
			tNumber.setTno(numberRequestDTO.getTno());
			tNumber.setCategory(numberRequestDTO.getCategory());
			tNumber.setStyleCreateyn(numberRequestDTO.getStyleCreateyn());
			tNumber.setDesignerId(numberRequestDTO.getDesignerId());
			tNumber.setStyleNo(numberRequestDTO.getStyleNo());
			tNumber.setStatus(numberRequestDTO.getStatus());
			tNumber.setCadId(numberRequestDTO.getCadId());
			tNumber.setCustNo(numberRequestDTO.getCustNo());
			tNumber.setCadId1(numberRequestDTO.getCadId1());
			tNumber.setRenderId(numberRequestDTO.getRenderId());
//			if (numberRequestDTO.getTdate() != null) {
//				tNumber.setTdate(DateUtils.convertUTCToDate(numberRequestDTO.getTdate()));
//			}
//			if (numberRequestDTO.getCadDate1() != null) {
//				tNumber.setCadDate1(DateUtils.convertUTCToDate(numberRequestDTO.getCadDate1()));
//			}
//			if (numberRequestDTO.getDesignDate() != null) {
//				tNumber.setDesignDate(DateUtils.convertUTCToDate(numberRequestDTO.getDesignDate()));
//			}
//			if (numberRequestDTO.getRenderDate() != null) {
//				tNumber.setRenderDate(DateUtils.convertUTCToDate(numberRequestDTO.getRenderDate()));
//			}
			tNumber.setCadDate(numberRequestDTO.getCadDate());
			tNumber.setCadDate1(numberRequestDTO.getCadDate1());
			tNumber.setDesignDate(numberRequestDTO.getDesignDate());
			tNumber.setRenderDate(numberRequestDTO.getRenderDate());

			tNumber.setBrandId(numberRequestDTO.getBrandId());

			if (numberRequestDTO.getNotes() != null) {
				tNumber.setNotes(numberRequestDTO.getNotes().getBytes());
			}
			if (numberRequestDTO.getDesignerNote() != null) {
				tNumber.setDesignerNote(numberRequestDTO.getDesignerNote().getBytes());
			}
			if (numberRequestDTO.getCadNote() != null) {
				tNumber.setCadNote(numberRequestDTO.getCadNote().getBytes());
			}
			if (numberRequestDTO.getCadNote1() != null) {
				tNumber.setCadNote1(numberRequestDTO.getCadNote1().getBytes());
			}
			if (numberRequestDTO.getRenderNote() != null) {
				tNumber.setRenderNote(numberRequestDTO.getRenderNote().getBytes());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return tNumber;
	}

}
