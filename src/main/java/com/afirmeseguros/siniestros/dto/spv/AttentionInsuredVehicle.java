package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionInsuredVehicle {
	
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("vehicle")
    private Vehicle vehicle;
    
    @JsonProperty("attention")
    private Long attention;

}
