package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionThirdAutos {
	
	
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("vehicle")
    private Vehicle vehicle;
    
    @JsonProperty("third_auto_insurance_data")
    private ThirdAutoInsuranceData thirdAutoInsuranceData;
    
    @JsonProperty("attention")
    private Long attention;
    
    @JsonProperty("third_auto_type")
    private String thirdAutoType;
    
    @JsonProperty("was_report")
    private Boolean wasReport;
    
    @JsonProperty("mutual_company")
    private Boolean mutualCompany;
    
    @JsonProperty("other_attention_number")
    private String otherAttentionNumber;

}
