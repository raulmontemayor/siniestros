package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdResponsible {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("responsibility")
	private String responsibility;
	
	@JsonProperty("third_type")
	private String thirdType;
	
	@JsonProperty("third")
	private String third;
	
	@JsonProperty("accept_responsibility")
	private Boolean acceptResponsibility;
	
	@JsonProperty("insurance_take_responsibility")
	private Boolean insuranceTakeResponsibility;
}
