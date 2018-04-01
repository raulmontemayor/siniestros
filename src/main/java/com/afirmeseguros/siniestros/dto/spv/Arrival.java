package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Arrival {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("photo")
	private String photo;
	
	@JsonProperty("point")
	private String point;
	
	@JsonProperty("date_time")
	private Date dateTime;
	
	@JsonProperty("plates")
	private String plates;
	
	@JsonProperty("serial_number")
	private String serialNumber;
	
	@JsonProperty("location")
	private String location;
	
	@JsonProperty("service")
	private Long service;
}
