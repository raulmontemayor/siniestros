package com.afirmeseguros.siniestros.dto.spv;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Coverage {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("key")
	private String key;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("deductible")
	private String deductible;
	
	@JsonProperty("assured_sum")
	private BigDecimal assuredSum;
	
	@JsonProperty("policy")
	private String policy;
}
