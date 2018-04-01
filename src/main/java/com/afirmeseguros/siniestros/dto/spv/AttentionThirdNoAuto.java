package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionThirdNoAuto {
    
	@JsonProperty("id")
    private String id;
    
	@JsonProperty("property_damage")
    private PropertyDamage propertyDamage;
    
	@JsonProperty("address")
    private Address address;
    
	@JsonProperty("attention")
    private Long attention;
    
	@JsonProperty("third_no_auto_type")
    private String thirdNoAutoType;
    
	@JsonProperty("third_no_auto_description")
    private String thirdNoAutoDescription;
}