package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionStatement {
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("vehicle_data")
	private VehicleData vehicleData;
	
	@JsonProperty("person")
	private Person person;
	
	@JsonProperty("attention")
	private Long attention;
	
	@JsonProperty("service_provider_signature")
	private Signature serviceProviderSignature;

	@JsonProperty("insured_signature")
	private Signature insuredSignature;
	
	@JsonProperty("attention_place")
	private String attentionPlace;
	
	@JsonProperty("statement_description")
	private String statementDescription;	

	@JsonProperty("accept_privacy_policy")
	private Boolean acceptPrivacyPolicy;

	@JsonProperty("observations")
	private String observations;
	
	@JsonProperty("folio")
	private String folio;



}
