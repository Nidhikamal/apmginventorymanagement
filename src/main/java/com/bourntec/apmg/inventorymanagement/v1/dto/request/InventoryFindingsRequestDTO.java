
package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.InventoryFindings;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryFindingsRequestDTO {
	private Long id;
	private String itemCode;
	private String findingId;
	private Integer pieces;
	private Integer price;
	private Integer total;
	private Integer wtPiece;
	private Integer karat;
	private String material;

	public InventoryFindings toModel(InventoryFindingsRequestDTO finding) {
		InventoryFindings findings = new InventoryFindings();

		try {
			findings.setItemCode(finding.getItemCode());
			findings.setFindingId(finding.getFindingId());
			findings.setKarat(finding.getKarat());
			findings.setMaterial(finding.getMaterial());
			findings.setPieces(finding.getPieces());
			findings.setPrice(finding.getPrice());
			findings.setTotal(finding.getTotal());
			findings.setWtPiece(finding.getWtPiece());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return findings;

	}
}



