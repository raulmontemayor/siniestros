package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceStatus {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("date_creation")
	private Date dateCreation;
	
	@JsonProperty("date_modification")
	private Date dateModification;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("object_id")
	private String objectId;
	
	@JsonProperty("observations")
	private String observations;
	
	@JsonProperty("owner")
	private String owner;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("modified_by")
	private String modifiedBy;

}
