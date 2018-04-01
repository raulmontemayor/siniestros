package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Person {
	
	@JsonProperty("id")
	private String id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("birth_date")
	private Date birthDate;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("last_name")
	private String lastName;
	
	@JsonProperty("mother_last_name")
	private String motherLastName;
	
	@JsonProperty("rfc")
	private String rfc;
	
	@JsonProperty("curp")
	private String curp;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("profile_picture")
	private String profilePicture;
}
