package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import java.util.Date;

import org.springframework.validation.annotation.Validated;

import com.bourntec.apmg.entity.InventoryMaterialsUsed;
import com.bourntec.apmg.entity.InventoryPriceHistory;

/**
 * 
 * Class is used as a data transfer object for inventory price history
 * 
 * @author Amal Chandra N A
 *
 */
@Validated
public class InventoryPriceHistoryRequestDTO {

	private Long id;
	private String itemCode;
	private Double oldMarkUp;
	private Double newMarkUp;
	private Double oldSalesPrice;
	private Double newSalesPrice;
	private Date changeDate;
	private Date changeTime;
	private String userId;
	private Double oldLabor;
	private Double newLabor;
	
	
	public InventoryPriceHistory tomodel(InventoryPriceHistoryRequestDTO invReqDTO) {
		InventoryPriceHistory invPrice=new InventoryPriceHistory();
		
		invPrice.setChangeDate(invReqDTO.getChangeDate());
		invPrice.setChangeTime(invReqDTO.getChangeTime());
		invPrice.setId(invReqDTO.getId());
		invPrice.setItemCode(invReqDTO.getItemCode());
		invPrice.setNewLabor(invReqDTO.getNewLabor());
		invPrice.setNewMarkUp(invReqDTO.getOldMarkUp());
		invPrice.setNewSalesPrice(invReqDTO.getNewSalesPrice());
		invPrice.setOldLabor(invReqDTO.getOldLabor());
		invPrice.setOldMarkUp(invReqDTO.getOldMarkUp());
		invPrice.setUserId(invReqDTO.getUserId());
		
		return invPrice;
	}
	
	
	
	public Long getId() {
		return id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public Double getOldMarkUp() {
		return oldMarkUp;
	}
	public Double getNewMarkUp() {
		return newMarkUp;
	}
	public Double getOldSalesPrice() {
		return oldSalesPrice;
	}
	public Double getNewSalesPrice() {
		return newSalesPrice;
	}
	public Date getChangeDate() {
		return changeDate;
	}
	public Date getChangeTime() {
		return changeTime;
	}
	public String getUserId() {
		return userId;
	}
	public Double getOldLabor() {
		return oldLabor;
	}
	public Double getNewLabor() {
		return newLabor;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public void setOldMarkUp(Double oldMarkUp) {
		this.oldMarkUp = oldMarkUp;
	}
	public void setNewMarkUp(Double newMarkUp) {
		this.newMarkUp = newMarkUp;
	}
	public void setOldSalesPrice(Double oldSalesPrice) {
		this.oldSalesPrice = oldSalesPrice;
	}
	public void setNewSalesPrice(Double newSalesPrice) {
		this.newSalesPrice = newSalesPrice;
	}
	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}
	public void setChangeTime(Date changeTime) {
		this.changeTime = changeTime;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setOldLabor(Double oldLabor) {
		this.oldLabor = oldLabor;
	}
	public void setNewLabor(Double newLabor) {
		this.newLabor = newLabor;
	}
}
