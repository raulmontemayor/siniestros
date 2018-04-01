package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionDocument {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("document_type")
	private String documentType;
	
	@JsonProperty("document_file")
	private String documentFile;
}
