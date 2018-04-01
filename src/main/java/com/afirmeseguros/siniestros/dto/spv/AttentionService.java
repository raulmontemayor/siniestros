package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionService {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("service_type")
	private String serviceType;
	
	@JsonProperty("service_provider")
	private ServiceProvider serviceProvider;
	
	@JsonProperty("phone_history")
	private List<PhoneHistory> phoneHistory;
	
	@JsonProperty("arrival")
	private Arrival arrival;
	
	@JsonProperty("appointment")
	private Appointment appointment;
	
	@JsonProperty("service_statuses")
	private List<ServiceStatus> serviceStatuses;
	
	@JsonProperty("service_number")
	private String serviceNumber;
	
	@JsonProperty("custom_service_number")
	private String customServiceNumber;
	
	@JsonProperty("observations")
	private String observations;
	
	@JsonProperty("date_assignation")
	private Date dateAssignation;
	
	@JsonProperty("is_assigned")
	private Boolean isAssigned;
	
	@JsonProperty("last_status")
	private String lastStatus;
	
	@JsonProperty("last_status_datetime")
	private Date lastStatusDatetime;
	
	@JsonProperty("attention")
	private Long attention;

}
