package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecoveryMoney {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("recovery")
	private String recovery;
	
	@JsonProperty("total_amount")
	private String totalAmount;
		
	@JsonProperty("cash")
	private String cash;
	
}
