package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DamagedPart {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("vehicle_damage")
	private String vehicleDamage;
	
	@JsonProperty("damage_part")
	private String damagePart;
	
	@JsonProperty("amount_of_damage")
	private String amountOfDamage;
	
}
