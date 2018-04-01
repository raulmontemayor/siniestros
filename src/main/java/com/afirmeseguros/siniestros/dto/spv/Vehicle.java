package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Vehicle {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("vehicle_occupants")
	private List<VehicleOccupant> vehicleOccupants;
	
	@JsonProperty("vehicle_data")
	private VehicleData vehicleData;
	
	@JsonProperty("driver")
	private Driver driver;
}
