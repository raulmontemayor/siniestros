package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProvider {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("username")
	private String username;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("is_active")
	private Boolean isActive;
	
	@JsonProperty("group")
	private String group;
}
