package com.afirmeseguros.siniestros.dto.spv;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
	    @JsonProperty("id")
	    private String id;
	    
	    @JsonProperty("point")
	    private String point;
	    
	    @JsonProperty("zip_code")
	    private String zipCode;
	    
	    @JsonProperty("colony")
	    private String colony;
	    
	    @JsonProperty("street")
	    private String street;
	    
	    @JsonProperty("exterior_number")
	    private String exteriorNumber;
	    
	    @JsonProperty("interior_number")
	    private String interiorNumber;
	    
	    @JsonProperty("between_street")
	    private String betweenStreet;
	    
	    @JsonProperty("and_street")
	    private String andStreet;
	    
	    @JsonProperty("reference")
	    private String reference;
	    
	    @JsonProperty("point_geos")
	    private PointGeos pointGeos;
	    
	    @JsonProperty("state")
	    private String state;
	    
	    @JsonProperty("city")
	    private String city;
}
