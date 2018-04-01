package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PointGeos {
	
	@JsonProperty("type")
	private String type;
	
	@JsonProperty("coordinates")
	private List<Double> coordinates;
}
