package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionTheftData {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("robbery_date")
	private Date robberyDate;
	
	@JsonProperty("was_violence")
	private Boolean wasViolence;
	
	@JsonProperty("need_ambulance")
	private Boolean needAmbulance;
	
	@JsonProperty("vehicle_parked")
	private Boolean vehicleParked;
	
	@JsonProperty("public_prosecutor_act")
	private Boolean publicProsecutorAct;
	
	@JsonProperty("public_prosecutor_act_date")
	private Date publicProsecutorActDate;
	
	@JsonProperty("sent_to_ivr")
	private Boolean sentToIvr;
	
	@JsonProperty("attention")
	private Long attention;

}
