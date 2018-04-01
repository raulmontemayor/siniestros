package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class InjuredPart {

    @JsonProperty("id")
    private String id;
    
    @JsonProperty("injury")
    private String injury;
    
    @JsonProperty("injured_part")
    private String injuredPart;
    
    @JsonProperty("body_zone")
    private String bodyZone;
}
