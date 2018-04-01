package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionClaimData {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("need_ambulance")
	private Boolean needAmbulance;
	
	@JsonProperty("same_driver")
	private Boolean sameDriver;
	
	@JsonProperty("driver_name")
	private String driverName;
	
	@JsonProperty("was_third_involved")
	private Boolean wasThirdInvolved;
	
	@JsonProperty("authority_present")
	private Boolean authorityPresent;
	
	@JsonProperty("vehicle_can_be_moved")
	private Boolean vehicleCanBeMoved;
	
	@JsonProperty("attention")
	private Long attention;

}
