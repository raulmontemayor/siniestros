package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneHistory {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("date_time") 
	private Date dateTime;
	
	@JsonProperty("service")
	private Long service;

}
