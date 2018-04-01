package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecoveryDocuments {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("sipac")
	private Boolean sipac;
	
	@JsonProperty("sipac_file")
	private String sipacFile;
	
	@JsonProperty("traditional")
	private Boolean traditional;
	
	@JsonProperty("traditional_file")
	private String traditionalFile;
	
	@JsonProperty("medical_order")
	private Boolean medicalOrder;
	
	@JsonProperty("medical_order_file")
	private String medicalOrderFile;
	
	@JsonProperty("recovery")
	private String recovery;
}
