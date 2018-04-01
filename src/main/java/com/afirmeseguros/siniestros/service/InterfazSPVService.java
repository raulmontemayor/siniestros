package com.afirmeseguros.siniestros.service;

import com.afirmeseguros.siniestros.dto.spv.PolicyResponse;
import com.afirmeseguros.siniestros.dto.spv.Report;
import com.afirmeseguros.siniestros.dto.spv.ReportResponse;

public interface InterfazSPVService {

	PolicyResponse getPolicy(String numeroPoliza, Integer inciso);

	ReportResponse processReport(Report report);

}
