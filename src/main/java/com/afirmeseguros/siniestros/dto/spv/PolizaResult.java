
package com.afirmeseguros.siniestros.dto.spv;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class PolizaResult {

    @SerializedName("policy")
    @Expose
    private String policy;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("policy_coverages")
    @Expose
    private List<Cobertura> policyCoverages;
    @SerializedName("number_parent_policy")
    @Expose
    private String numberParentPolicy;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("renovation")
    @Expose
    private String renovation;
    @SerializedName("product_type")
    @Expose
    private String productType;
    @SerializedName("date_from")
    @Expose
    private Date dateFrom;
    @SerializedName("date_to")
    @Expose
    private Date dateTo;
    @SerializedName("coverage_type")
    @Expose
    private String coverageType;
    @SerializedName("net_bonus")
    @Expose
    private String netBonus;
    @SerializedName("policy_right")
    @Expose
    private String policyRight;
    @SerializedName("iva")
    @Expose
    private Integer iva;
    @SerializedName("total_bonus")
    @Expose
    private String totalBonus;
    @SerializedName("client_code")
    @Expose
    private String clientCode;
    @SerializedName("name_contractor")
    @Expose
    private String nameContractor;
    @SerializedName("rfc")
    @Expose
    private String rfc;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("name_titular")
    @Expose
    private String nameTitular;
    @SerializedName("name_driver")
    @Expose
    private String nameDriver;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("vehicle_type")
    @Expose
    private String vehicleType;
    @SerializedName("brand")
    @Expose
    private String brand;
    @SerializedName("year_model")
    @Expose
    private String yearModel;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("use_type")
    @Expose
    private String useType;
    @SerializedName("plate")
    @Expose
    private String plate;
    @SerializedName("serial_number")
    @Expose
    private String serialNumber;
    @SerializedName("motor")
    @Expose
    private String motor;
    @SerializedName("circulation_state")
    @Expose
    private String circulationState;
    @SerializedName("agent")
    @Expose
    private String agent;
    @SerializedName("mail_agent")
    @Expose
    private String mailAgent;
    @SerializedName("phone_agent")
    @Expose
    private String phoneAgent;
    @SerializedName("payment_type")
    @Expose
    private String paymentType;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("payment_channel")
    @Expose
    private String paymentChannel;
    @SerializedName("tracking_equipment")
    @Expose
    private Boolean trackingEquipment;
    @SerializedName("tracking_equipment_mail")
    @Expose
    private String trackingEquipmentMail;
    @SerializedName("financing_policy")
    @Expose
    private String financingPolicy;
    @SerializedName("financing_entity")
    @Expose
    private String financingEntity;
    @SerializedName("is_back_to_home")
    @Expose
    private Boolean isBackToHome;
    @SerializedName("segmentation")
    @Expose
    private String segmentation;

}