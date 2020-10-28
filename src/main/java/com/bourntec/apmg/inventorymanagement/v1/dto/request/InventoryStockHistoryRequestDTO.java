package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.Date;

import javax.persistence.Column;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryRank;
import com.bourntec.apmg.entity.InventoryStockHistory;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * Class is used as a data transfer object for Stock history 
 * 
 * @author Babu
 *
 */
@Validated
@Getter
@Setter
public class InventoryStockHistoryRequestDTO {

	
	private Long id;
	
	private String itemCode;
	
	private Integer oldPieces;
	
	private Integer newPieces;
	
	private Date changeDate;
	
	private Date changeTime;
	
	private String userId;
	
	private Double oldWeight;
	
	private Double newWeight;
	
	private String unitCharge;

	
	
	public InventoryStockHistory toModel(InventoryStockHistoryRequestDTO invRankRequestDTO) {
		InventoryStockHistory invrank = new InventoryStockHistory();
		
		try {
			invrank.setId(invRankRequestDTO.getId());
			invrank.setItemCode(invRankRequestDTO.getItemCode());
			invrank.setOldPieces(invRankRequestDTO.getOldPieces());
			invrank.setNewPieces(invRankRequestDTO.getNewPieces());
			invrank.setChangeDate(invRankRequestDTO.getChangeDate());
			invrank.setChangeTime(invRankRequestDTO.getChangeTime());
			invrank.setUserId(invRankRequestDTO.getUserId());
			invrank.setOldWeight(invRankRequestDTO.getOldWeight());
			invrank.setNewWeight(invRankRequestDTO.getNewWeight());
			invrank.setUnitCharge(invRankRequestDTO.getUnitCharge());
		} catch (Exception e) {
            e.printStackTrace();
		}
		return invrank;

	}
	

	
}
