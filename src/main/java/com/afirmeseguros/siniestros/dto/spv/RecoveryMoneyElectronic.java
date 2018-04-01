package com.afirmeseguros.siniestros.dto.spv;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecoveryMoneyElectronic {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("bank")
	private String bank;
	
	@JsonProperty("amount")
	private String amount;
	
	@JsonProperty("authorization_code")
	private String authorizationCode;
	
	@JsonProperty("recovery")
	private String recovery;
	

}
