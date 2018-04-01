package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleOccupant {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("injury")
	private Injury injury;
	
	@JsonProperty("person")
	private Person person;
		
	@JsonProperty("vehicle")
	private String vehicle;

}
