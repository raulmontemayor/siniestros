package com.afirmeseguros.siniestros.dto.spv;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Cobertura {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("assured_sum")
    @Expose
    private Double assuredSum;
    @SerializedName("policy")
    @Expose
    private String policy;
}
