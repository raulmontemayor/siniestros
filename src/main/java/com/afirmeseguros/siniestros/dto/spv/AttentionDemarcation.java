package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionDemarcation {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("circumstance_a")
	private String circumstanceA;
	
	@JsonProperty("circumstance_b")
	private String circumstanceB;
	
	@JsonProperty("responsible")
	private String responsible;
	
	@JsonProperty("description")
	private String description;
	
}
