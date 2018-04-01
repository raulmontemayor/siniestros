package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Report {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("address")
	private Address address;
	
	@JsonProperty("policy")
	private String policy;
	
	@JsonProperty("_policy")
	private PolicyData policyData;
	
	@JsonProperty("attention_date")
	private Date attentionDate;
	
	@JsonProperty("attention_claim_data")
	private AttentionClaimData attentionClaimData;
	
	@JsonProperty("attention_theft_data")
	private AttentionTheftData attentionTheftData;
	
	@JsonProperty("attention_statement")
	private AttentionStatement attentionStatement;
	
	@JsonProperty("attention_demarcation")
	private AttentionDemarcation attentionDemarcation;
	
	@JsonProperty("attention_recreation")
	private AttentionRecreation attentionRecreation;
	
	@JsonProperty("attention_valuations")
	private List<AttentionValuation> attentionValuations;
	
	@JsonProperty("attention_image_evidences")
	private List<AttentionImageEvidence> attentionImageEvidence;
	
    @JsonProperty("attention_insured_vehicle")
    private AttentionInsuredVehicle attentionInsuredVehicle;
    
    @JsonProperty("attention_third_autos")
    private List<AttentionThirdAutos> attentionThirdAutos;
    
    @JsonProperty("attention_third_no_autos")
    private List<AttentionThirdNoAuto> attentionThirdNoAutos;
    
    @JsonProperty("attention_third_pedestrians")
    private List<AttentionThirdPedestrian> attentionThirdPedestrians;
    
    @JsonProperty("attention_documents")
    private List<AttentionDocument> attentionDocuments;
    
    @JsonProperty("attention_responsibility")
    private AttentionResponsibility attentionResponsibility;
    
    @JsonProperty("attention_recoveries")
    private List<AttentionRecovery> attentionRecoveries;
    
    @JsonProperty("attention_estimates")
    private List<AttentionEstimate> attentionEstimates;
    
    @JsonProperty("attention_services")
    private List<AttentionService> attentionServices;
    
    @JsonProperty("attention_type")
    private String attentionType;
    
	@JsonProperty("date_creation")
	private Date dateCreation;
	
	@JsonProperty("date_modification")
	private Date dateModification;
	
	@JsonProperty("policy_number")
	private String policyNumber;
    
    @JsonProperty("attention_without_policy")
    private Boolean attentionWithoutPolicy;
    
    @JsonProperty("attention_number")
    private String attentionNumber;
    
    @JsonProperty("attention_number_business")
    private String attentionNumberBusiness;
    
    @JsonProperty("location")
    private String location;
    
    @JsonProperty("report_person_name")
    private String reportPersonName;
    
    @JsonProperty("report_person_last_name")
    private String reportPersonLastName;
    
    @JsonProperty("report_person_mother_last_name")
    private String reportPersonMotherLastName;
    
    @JsonProperty("report_person_phone")
    private String reportPersonPhone;
    
    @JsonProperty("was_arrived")
    private Boolean wasArrived;
    
    @JsonProperty("owner")
    private String owner;
    
    @JsonProperty("created_by")
    private String createdBy;
    
    @JsonProperty("modified_by")
    private String modifiedBy;
    
    @JsonProperty("insurance_company")
    private String insuranceCompany;
    
    @JsonProperty("vehicle_data")
    private String vehicleData;
	
}
