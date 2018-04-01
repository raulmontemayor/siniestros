package com.afirmeseguros.siniestros.service.impl;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import com.afirmeseguros.siniestros.db.dto.ReportProcessorLogEntity;
import com.afirmeseguros.siniestros.db.repository.ReportProcessorLogRepository;
import com.afirmeseguros.siniestros.dto.spv.Coverage;
import com.afirmeseguros.siniestros.dto.spv.PolicyResponse;
import com.afirmeseguros.siniestros.dto.spv.Report;
import com.afirmeseguros.siniestros.dto.spv.ReportResponse;
import com.afirmeseguros.siniestros.exception.GenericException;
import com.afirmeseguros.siniestros.exception.ResourceNotFoundException;
import com.afirmeseguros.siniestros.service.InterfazSPVService;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
public class InterfazSPVServiceImpl implements InterfazSPVService {
	
	
	/** Log de InterfazSPVServiceImpl */
	private static final Logger LOG = LoggerFactory.getLogger(InterfazSPVServiceImpl.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ReportProcessorLogRepository reportProcessorLogRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private static final String SCHEMA = "siniestros";
	private static final String CATALOG = "PKGSIN_INTERFAZ_SPV";

	@Override
	public PolicyResponse getPolicy(String numeroPoliza, Integer inciso) {
		try {
			final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
	                .withSchemaName(SCHEMA)
					.withCatalogName(CATALOG)
					.withProcedureName("get_policy")
					.declareParameters(
						new SqlParameter("pPolicyNumber", Types.VARCHAR),
						new SqlParameter("pInciso", Types.NUMERIC))
	                .returningResultSet("pCursor",
	                        new BeanPropertyRowMapper<PolicyResponse>(PolicyResponse.class));
			
			final SqlParameterSource parameter = new MapSqlParameterSource()
					.addValue("pPolicyNumber", numeroPoliza)
					.addValue("pInciso", inciso);
			final List<PolicyResponse> lstCallResponse =  (List<PolicyResponse>) simpleJdbcCall.execute(parameter).get("pCursor");
			if (CollectionUtils.isEmpty(lstCallResponse)) {
				throw new ResourceNotFoundException();
			} else {
				SimpleJdbcCall simpleJdbcCall2 = new SimpleJdbcCall(dataSource)
		                .withSchemaName(SCHEMA)
						.withCatalogName(CATALOG)
						.withProcedureName("get_coverage")
						.declareParameters(
							new SqlParameter("pPolicyNumber", Types.VARCHAR),
							new SqlParameter("pInciso", Types.NUMERIC))
		                .returningResultSet("pCursor",
		                        new BeanPropertyRowMapper<Coverage>(Coverage.class));
				List<Coverage> lstCoverage = (List<Coverage>) simpleJdbcCall2.execute(parameter).get("pCursor");
				lstCallResponse.get(0).setPolicyCoverages(lstCoverage);
				return lstCallResponse.get(0);
			}
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			LOG.error("-- getPolicy()", e);
			throw new GenericException(e.getMessage());	
		}
	}

	@Override
	public ReportResponse processReport(Report report) {
		try {
			final String id = saveLog(report);
			makeReport(report);
			final ReportResponse response = new ReportResponse();
			response.setNumber(id);
			return response;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	private void makeReport(Report report) {
		this.saveReport(report);
		
	}

	private void saveReport(Report report) {
		try {
			final SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(dataSource)
	                .withSchemaName(SCHEMA)
					.withCatalogName(CATALOG)
					.withProcedureName("saveReport")
					.declareParameters(
						new SqlParameter("pNum_Poliza", Types.VARCHAR),
						new SqlParameter("pId_Lin_Negocio", Types.NUMERIC),
						new SqlParameter("pId_Inciso", Types.NUMERIC),
						new SqlParameter("pCve_Estado", Types.NUMERIC),
						new SqlParameter("pCve_Ciudad", Types.NUMERIC),
						new SqlParameter("pUbicacion", Types.NUMERIC),
						new SqlParameter("pColonia", Types.NUMERIC),
						new SqlParameter("pTx_Siniestro", Types.NUMERIC),
                        new SqlParameter("pNom_Reporta", Types.NUMERIC),
                        new SqlParameter("pNom_Conductor", Types.NUMERIC),
                        new SqlParameter("pEdad_Cond", Types.NUMERIC),
                        new SqlParameter("pcve_Sexo_Cond", Types.NUMERIC),
                        new SqlParameter("pid_giro_ocup", Types.NUMERIC),
                        new SqlParameter("pNum_lic_cond", Types.NUMERIC),
                        new SqlParameter("pcvel_t_lic_cond", Types.NUMERIC),
                        new SqlParameter("pf_venc_lic_cond", Types.NUMERIC),
                        new SqlParameter("pid_taller_asig", Types.NUMERIC),
                        new SqlParameter("pCodigo_Postal", Types.NUMERIC),
                        new SqlParameter("pid_colonia", Types.NUMERIC),
                        new SqlParameter("pTelefs_Reporta", Types.NUMERIC),
                        new SqlParameter("pCve_Usuario", Types.NUMERIC),
                        new SqlParameter("pid_ajustador", Types.NUMERIC),
                        new SqlParameter("pFH_Reportado", Types.NUMERIC),
                        new SqlParameter("pFH_Ocurrido", Types.NUMERIC),
                        new SqlParameter("pFH_Asignacion", Types.NUMERIC),
                        new SqlParameter("pFH_Cita", Types.NUMERIC),
                        new SqlParameter("pFH_Contacto", Types.NUMERIC),
                        new SqlParameter("pFH_Terminacion", Types.NUMERIC),
                        new SqlParameter("pB_Cia_Respon", Types.NUMERIC),
                        new SqlParameter("pId_Cia_Aseg_Resp", Types.NUMERIC),
                        new SqlParameter("pId_Causa_Sin", Types.NUMERIC),
                        new SqlParameter("pCveL_Lugar_Ajust", Types.NUMERIC),
                        new SqlParameter("pCveL_T_Resp", Types.NUMERIC),
                        new SqlParameter("pCve_Term_Ajust", Types.NUMERIC),
                        new SqlParameter("pB_Fuga_Terc_Resp", Types.NUMERIC),
                        new SqlParameter("pcve_t_perdida", Types.NUMERIC),
                        new SqlParameter("pPlaca", Types.NUMERIC),
                        new SqlParameter("pEstimacionInf", Types.NUMERIC),
                        new SqlParameter("pPlacaAjusta", Types.NUMERIC),
                        new SqlParameter("pId_Cod_Resp", Types.NUMERIC),
                        new SqlParameter("pDesc_Codigo", Types.NUMERIC))
	                .returningResultSet("p_result_cursor",
	                        new BeanPropertyRowMapper<PolicyResponse>(PolicyResponse.class));
			
			final SqlParameterSource parameter = new MapSqlParameterSource()
					.addValue("pNum_Poliza", report.getPolicy())
					.addValue("pId_Lin_Negocio", 1) //TODO default
					.addValue("pId_Inciso", report.getIndent())// TODO validar si se puede usar report.getPolicyNumber()
					.addValue("pCve_Estado", report.getAttentionInsuredVehicle().getVehicle().getDriver().getAddress().getState())
					.addValue("pCve_Ciudad", report.getAttentionInsuredVehicle().getVehicle().getDriver().getAddress().getCity())
					.addValue("pUbicacion", report.getAttentionInsuredVehicle().getVehicle().getDriver().getAddress().getStreet() 
							+ " " + report.getAttentionInsuredVehicle().getVehicle().getDriver().getAddress().getExteriorNumber())
					.addValue("pColonia", report.getAttentionInsuredVehicle().getVehicle().getDriver().getAddress().getColony())
					.addValue("pTx_Siniestro", report.getAttentionStatement().getVehicleData().geto)
		            .addValue("pNom_Reporta", "")
		            .addValue("pNom_Conductor", "")
		            .addValue("pEdad_Cond", "")
		            .addValue("pcve_Sexo_Cond", "")
		            .addValue("pid_giro_ocup", "")
		            .addValue("pNum_lic_cond", "")
		            .addValue("pcvel_t_lic_cond", "")
		            .addValue("pf_venc_lic_cond", "")
		            .addValue("pid_taller_asig", "")
		            .addValue("pCodigo_Postal", "")
		            .addValue("pid_colonia", "")
		            .addValue("pTelefs_Reporta", "")
		            .addValue("pCve_Usuario", "")
		            .addValue("pid_ajustador", "")
		            .addValue("pFH_Reportado", "")
		            .addValue("pFH_Ocurrido", "")
		            .addValue("pFH_Asignacion", "")
		            .addValue("pFH_Cita", "")
		            .addValue("pFH_Contacto", "")
		            .addValue("pFH_Terminacion", "")
		            .addValue("pB_Cia_Respon", "")
		            .addValue("pId_Cia_Aseg_Resp", "")
		            .addValue("pId_Causa_Sin", "")
		            .addValue("pCveL_Lugar_Ajust", "")
		            .addValue("pCveL_T_Resp", "")
		            .addValue("pCve_Term_Ajust", "")
		            .addValue("pB_Fuga_Terc_Resp", "")
		            .addValue("pcve_t_perdida", "")
		            .addValue("pPlaca", "")
		            .addValue("pEstimacionInf", "")
		            .addValue("pPlacaAjusta", "")
		            .addValue("pId_Cod_Resp", "")
		            .addValue("pDesc_Codigo", "");
			final List<PolicyResponse> lstCallResponse =  (List<PolicyResponse>) simpleJdbcCall.execute(parameter).get("pCursor");
			if (CollectionUtils.isEmpty(lstCallResponse)) {
				throw new ResourceNotFoundException();
			} else {
				SimpleJdbcCall simpleJdbcCall2 = new SimpleJdbcCall(dataSource)
		                .withSchemaName(SCHEMA)
						.withCatalogName(CATALOG)
						.withProcedureName("get_coverage")
						.declareParameters(
							new SqlParameter("pPolicyNumber", Types.VARCHAR),
							new SqlParameter("pInciso", Types.NUMERIC))
		                .returningResultSet("pCursor",
		                        new BeanPropertyRowMapper<Coverage>(Coverage.class));
				List<Coverage> lstCoverage = (List<Coverage>) simpleJdbcCall2.execute(parameter).get("pCursor");
				lstCallResponse.get(0).setPolicyCoverages(lstCoverage);
				return lstCallResponse.get(0);
			}
		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			LOG.error("-- getPolicy()", e);
			throw new GenericException(e.getMessage());	
		}
	}

	private String saveLog(Report report) {
		try {
			final ReportProcessorLogEntity entity = new ReportProcessorLogEntity();
			entity.setCreatedDate(new Date());
			entity.setExternalId(report.getId());
			entity.setJsonData(mapper.writeValueAsString(report));
			reportProcessorLogRepository.save(entity);
			return entity.getId().toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
