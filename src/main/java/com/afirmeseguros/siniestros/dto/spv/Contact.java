package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Contact {

    @JsonProperty("id")
    private String id;
    
    @JsonProperty("contact_phones")
    private List<ContactPhone> contactPhones;
    
    @JsonProperty("contact_identifications")
    private List<ContactIdentification> contactIdentifications;
    
    @JsonProperty("preferential_contact")
    private String preferentialContact;
    
    @JsonProperty("email")
    private String email;
}
