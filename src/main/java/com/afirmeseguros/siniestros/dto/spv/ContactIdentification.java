package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactIdentification {
    
	@JsonProperty("id")
    private String id;
    
	@JsonProperty("contact")
    private String contact;
    
	@JsonProperty("type_id")
    private String typeId;
    
	@JsonProperty("number_id")
    private String numberId;
    
	@JsonProperty("photo")
    private String photo;
}
