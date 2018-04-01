package com.afirmeseguros.siniestros.dto.spv;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AttentionRecovery {
    
	@JsonProperty("id")
    private String id;
    
	@JsonProperty("recovery_documents")
    private RecoveryDocuments recoveryDocuments;
    
	@JsonProperty("recovery_money")
    private RecoveryMoney recoveryMoney;
    
	@JsonProperty("recovery_money_electronics")
    private List<RecoveryMoneyElectronic> recoveryMoneyElectronics;
    
	@JsonProperty("recovery_money_cheques")
    private List<RecoveryMoneyCheque> recoveryMoneyCheques;
    
	@JsonProperty("attention")
    private Long attention;
    
	@JsonProperty("recovery_type")
    private String recoveryType;
	
	@JsonProperty("in_power_of")
    private String inPowerOf;
    
	@JsonProperty("who_recover")
    private String whoRecover;
    

    

}
