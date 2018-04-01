package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionResponsibility {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("third_responsible")
	private List<ThirdResponsible> thirdResponsible;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("who_is_responsible")
	private String whoIsResponsible;
	
	@JsonProperty("table_of_controversy")
	private Boolean tableOfControversy;
}
