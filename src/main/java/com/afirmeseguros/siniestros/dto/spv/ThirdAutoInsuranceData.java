package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ThirdAutoInsuranceData {
    
	@JsonProperty("id")
    private String id;
    
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("policy_valid_since")
    private Date policyValidSince;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("policy_valid_to")
    private Date policyValidTo;
	
	@JsonProperty("coverage_type")
    private String coverageType;
	
	@JsonProperty("insurance_company")
    private String insuranceCompany;
    
	@JsonProperty("attention_number")
    private String attentionNumber;
    
	@JsonProperty("policy")
    private String policy;
    
	@JsonProperty("service_provider")
    private String serviceProvider;
    
	@JsonProperty("service_provider_phone")
    private String serviceProviderPhone;
    
	@JsonProperty("policy_titular")
    private String policyTitular;
    
	@JsonProperty("third_auto")
    private String thirdAuto;
    

}
