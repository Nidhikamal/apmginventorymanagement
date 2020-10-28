package com.bourntec.apmg.inventorymanagement.v1.dto.request;

import com.bourntec.apmg.entity.CodeClarity;

public class CodeClarityRequestDTO {
	private String clarityId;
	private String clarityName;

	public String getClarityId() {
		return clarityId;
	}

	public void setClarityId(String clarityId) {
		this.clarityId = clarityId;
	}

	public String getClarityName() {
		return clarityName;
	}

	public void setClarityName(String clarityName) {
		this.clarityName = clarityName;
	}

	public CodeClarity toModel(CodeClarityRequestDTO codesCountryRequestDTO) {
		// TODO Auto-generated method stub
		CodeClarity cl = new CodeClarity();
		cl.setClarityId(codesCountryRequestDTO.getClarityId());
		cl.setClarityName(codesCountryRequestDTO.getClarityName());
		return cl;
	}

}
