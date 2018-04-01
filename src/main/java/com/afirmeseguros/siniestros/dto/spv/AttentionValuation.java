package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionValuation {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("vehicle_damage")
	private VehicleDamage vehicleDamage;
	
	@JsonProperty("affected")
	private String affected;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("vehicle")
	private String vehicle;

}
