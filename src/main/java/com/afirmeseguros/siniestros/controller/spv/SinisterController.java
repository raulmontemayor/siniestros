package com.afirmeseguros.siniestros.controller.spv;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.afirmeseguros.siniestros.dto.spv.PolizaResult;

@RestController
public class SinisterController {
	
	
	/** Log de SinisterController */
	private static final Logger LOG = LoggerFactory.getLogger(SinisterController.class);

	@RequestMapping(name = "/polizas", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public PolizaResult poliza(@RequestParam(value = "q") String numeroPoliza) {
		LOG.trace("poliza() -->");
		PolizaResult result = new PolizaResult();
		result.setDateFrom(new Date());
		result.setId("asudhfaksjdnnakfds");
		return result;
	}

}
