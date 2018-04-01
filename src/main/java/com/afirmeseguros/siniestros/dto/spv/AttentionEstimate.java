package com.afirmeseguros.siniestros.dto.spv;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionEstimate {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("coverage")
	private String coverage;
	
	@JsonProperty("coverage_key")
	private String coverageKey;
	
	@JsonProperty("date_creation")
	private Date dateCreation;
	
	@JsonProperty("date_modification")
	private Date dateModification;
	
	@JsonProperty("amount")
	private BigDecimal amount;
	
	@JsonProperty("coverage_description")
	private String coverageDescription;
	
	@JsonProperty("owner")
	private String owner;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("modified_by")
	private String modifiedBy;
}
