package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VehicleData {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("version")
	private String version;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("sub_brand")
	private String subBrand;
	
	@JsonProperty("model")
	private Integer model;
	
	@JsonProperty("plates")
	private String plates;
	
	@JsonProperty("serial")
	private String serial;
	
	@JsonProperty("motor")
	private String motor;
	
	@JsonProperty("color")
	private String color;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("vehicle_type")
	private String vehicleType;
}
