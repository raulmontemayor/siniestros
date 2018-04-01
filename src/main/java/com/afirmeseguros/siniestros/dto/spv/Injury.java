package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Injury {
    
	@JsonProperty("id")
    private String id;
    
	@JsonProperty("injured_parts")
    private List<InjuredPart> injuredParts;
	
	@JsonProperty("injury_level")
    private String injuryLevel;
    
	@JsonProperty("was_medical_order")
    private Boolean wasMedicalOrder;
    
	@JsonProperty("observations")
    private String observations;
    

}
