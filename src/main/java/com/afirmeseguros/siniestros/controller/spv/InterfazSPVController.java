package com.afirmeseguros.siniestros.controller.spv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afirmeseguros.siniestros.dto.spv.PolicyResponse;
import com.afirmeseguros.siniestros.dto.spv.Report;
import com.afirmeseguros.siniestros.dto.spv.ReportResponse;
import com.afirmeseguros.siniestros.service.InterfazSPVService;

import lombok.Getter;
import lombok.Setter;

@RestController
@Getter
@Setter
public class InterfazSPVController {
	
	
	/** Log de InterfazSPVController */
	private static final Logger LOG = LoggerFactory.getLogger(InterfazSPVController.class);
	
	@Autowired
	private InterfazSPVService interfazSPVService;

	
	@RequestMapping(value="/polizas")
	public PolicyResponse getPolicy(@RequestParam(name="numero") String numeroPoliza, @RequestParam (required = false) Integer inciso) {
		try {
			inciso = inciso == null ? 1 : inciso;
			MDC.put("poliza", numeroPoliza);
			MDC.put("inciso", inciso.toString());
			LOG.trace("--getPolicy()");
			return interfazSPVService.getPolicy(numeroPoliza, inciso);
		} finally {
			MDC.clear();
		}

	}
	
	@RequestMapping(value="/reporte", method = {RequestMethod.POST}, consumes = "application/json")
	public ReportResponse processReport(@RequestBody Report report) {
		try {
			MDC.put("poliza", report.getPolicy());
			MDC.put("reportId", report.getId());
			LOG.debug("--processReport() \n{}", report);
			if (report.getPolicyNumber() == null) {
				report.setPolicyNumber("1");
			}  
			return interfazSPVService.processReport(report); 
		} finally {
			MDC.clear();
		}

	}

}
