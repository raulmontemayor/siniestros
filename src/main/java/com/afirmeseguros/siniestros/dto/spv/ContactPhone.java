package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactPhone {

    @JsonProperty("id")
    private String id;
    
    @JsonProperty("contact")
    private String contact;
    
    @JsonProperty("phone_type")
    private String phoneType;
    
    @JsonProperty("phone")
    private String phone;
    
    @JsonProperty("extension")
    private String extension;
    
    @JsonProperty("main")
    private Boolean main;
}
