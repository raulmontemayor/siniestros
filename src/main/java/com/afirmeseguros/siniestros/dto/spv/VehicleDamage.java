package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleDamage {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("preexistence_damaged_parts")
	private List<DamagedPart> preexistenceDamagedParts;
	
	@JsonProperty("consequence_damaged_parts")
	private List<DamagedPart> consequenceDamagedParts;
	
	@JsonProperty("vehicle_class")
	private String vehicleClass;
	
	@JsonProperty("first_impact")
	private String firstImpact;
	
	@JsonProperty("damage_level")
	private String damageLevel;
	
	@JsonProperty("preexistence_observations")
	private String preexistenceObservations;
	
	@JsonProperty("consequence_observations")
	private Object consequenceObservations;
	
	@JsonProperty("estimated_cost")
	private String estimatedCost;
	


}
