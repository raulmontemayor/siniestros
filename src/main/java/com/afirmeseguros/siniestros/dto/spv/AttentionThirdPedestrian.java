package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionThirdPedestrian {
    
	@JsonProperty("id")
    private String id;
    
	@JsonProperty("person")
    private Person person;
    
	@JsonProperty("injury")
    private Injury injury;
    
	@JsonProperty("attention")
    private Long attention;

}
