package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PolicyData {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("policy_coverages")
	private List<Coverage> policyCoverages;
	
	@JsonProperty("number_parent_policy")
	private String numberParentPolicy;
	
	@JsonProperty("policy")
	private String policy;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("version")
	private String version;
	
	@JsonProperty("number")
	private String number;
	
	@JsonProperty("renovation")
	private String renovation;
	
	@JsonProperty("product_type")
	private String productType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("date_from")
	private Date dateFrom;
	
	@JsonProperty("date_to")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dateTo;
	
	@JsonProperty("coverage_type")
	private String coverageType;
	
	@JsonProperty("net_bonus")
	private Double netBonus;
	
	@JsonProperty("policy_right")
	private String policyRight;
	
	@JsonProperty("iva")
	private Double iva;
	
	@JsonProperty("total_bonus")
	private String totalBonus;
	
	@JsonProperty("client_code")
	private String clientCode;
	
	@JsonProperty("name_contractor")
	private String nameContractor;
	
	@JsonProperty("rfc")
	private String rfc;
	
	@JsonProperty("address")
	private String address;
	
	@JsonProperty("name_titular")
	private String nameTitular;
	
	@JsonProperty("phone_titular")
	private String phoneTitular;
	
	@JsonProperty("name_driver")
	private String nameDriver;
	
	@JsonProperty("age")
	private String age;
	
	@JsonProperty("gender")
	private String gender;
	
	@JsonProperty("vehicle_type")
	private String vehicleType;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("year_model")
	private String yearModel;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("use_type")
	private String useType;
	
	@JsonProperty("plate")
	private String plate;
	
	@JsonProperty("serial_number")
	private String serialNumber;
	
	@JsonProperty("motor")
	private String motor;
	
	@JsonProperty("circulation_state")
	private String circulationState;
	
	@JsonProperty("agent")
	private String agent;
	
	@JsonProperty("agent_key")
	private String agentKey;
	
	@JsonProperty("mail_agent")
	private String mailAgent;
	
	@JsonProperty("phone_agent")
	private String phoneAgent;
	
	@JsonProperty("payment_type")
	private String paymentType;
	
	@JsonProperty("currency")
	private String currency;
	
	@JsonProperty("payment_channel")
	private String paymentChannel;
	
	@JsonProperty("tracking_equipment")
	private Boolean trackingEquipment;
	
	@JsonProperty("tracking_equipment_mail")
	private String trackingEquipmentMail;
	
	@JsonProperty("financing_policy")
	private String financingPolicy;
	
	@JsonProperty("financial_entity")
	private String financialEntity;
	
	@JsonProperty("is_back_to_home")
	private Boolean isBackToHome;
	
	@JsonProperty("office")
	private String office;
	
	@JsonProperty("segmentation")
	private String segmentation;
	
	@JsonProperty("query_url")
	private String queryUrl;
	
	@JsonProperty("insurance_company")
	private String insuranceCompany;
	
	@JsonProperty("vehicle_data")
	private String vehicleData;
}
