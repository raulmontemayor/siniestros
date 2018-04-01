package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionImageEvidence {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("folder")
	private String folder;
	
	@JsonProperty("image")
	private String image;
	
	@JsonProperty("thumbnail")
	private String thumbnail;
	
	@JsonProperty("attention")
	private Long attention;

}
