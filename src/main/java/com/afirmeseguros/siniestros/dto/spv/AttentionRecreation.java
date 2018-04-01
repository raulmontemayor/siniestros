package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionRecreation {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("signature")
	private Signature signature;
	
	@JsonProperty("file")
	private String file;
}
