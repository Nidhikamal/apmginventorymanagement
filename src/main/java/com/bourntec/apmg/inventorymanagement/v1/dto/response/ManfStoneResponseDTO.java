package com.bourntec.apmg.inventorymanagement.v1.dto.response;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Srijini
 *
 */
@Getter
@Setter
public class ManfStoneResponseDTO {

	private String jobNo;

	private Double item_no;

	private String itemCode;

	private Double no_stone_in_w;

	private Double no_stone_in_p;

	private Double no_stone_out_w;

	private Double no_stone_out_p;

	private Double karat;

	private Double cost_stone;

	private String desc1;

	private String locationCode;

	private String unit_charge;

	private String clarity;

	private String color;

	private String setting;

	private String shape;
}
