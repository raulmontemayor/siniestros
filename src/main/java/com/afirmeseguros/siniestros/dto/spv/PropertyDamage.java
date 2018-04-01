package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyDamage {
    
	@JsonProperty("id")
    private String id;
    
	@JsonProperty("consequence_damages")
    private String consequenceDamages;
    
	@JsonProperty("preexistence_damages")
    private String preexistenceDamages;
    
	@JsonProperty("person_claim_damages")
    private Boolean personClaimDamages;
    
	@JsonProperty("full_name_claim_damages")
    private String fullNameClaimDamages;
}
