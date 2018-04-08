package com.afirmeseguros.siniestros.service.impl;

import java.sql.Types;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
					.withProcedureName("pAlta_Reporte")
					.declareParameters(
						new SqlParameter("pId_Reporte_sin", Types.NUMERIC),
						new SqlParameter("pNum_Poliza", Types.VARCHAR),
						new SqlParameter("pId_Lin_Negocio", Types.NUMERIC),
						new SqlParameter("pId_Inciso", Types.NUMERIC),
						new SqlParameter("pCve_Estado", Types.VARCHAR),
						new SqlParameter("pCve_Ciudad", Types.VARCHAR),
						new SqlParameter("pUbicacion", Types.VARCHAR),
						new SqlParameter("pColonia", Types.VARCHAR),
						new SqlParameter("pTx_Siniestro", Types.VARCHAR),
                        new SqlParameter("pNom_Reporta", Types.VARCHAR),
                        new SqlParameter("pNom_Conductor", Types.VARCHAR),
                        new SqlParameter("pEdad_Cond", Types.NUMERIC),
                        new SqlParameter("pcve_Sexo_Cond", Types.VARCHAR),
                        new SqlParameter("pid_giro_ocup", Types.VARCHAR),
                        new SqlParameter("pNum_lic_cond", Types.VARCHAR),
                        new SqlParameter("pcvel_t_lic_cond", Types.VARCHAR),
                        new SqlParameter("pf_venc_lic_cond", Types.DATE),
                        new SqlParameter("pid_taller_asig", Types.VARCHAR),
                        new SqlParameter("pCodigo_Postal", Types.VARCHAR),
                        new SqlParameter("pid_colonia", Types.NUMERIC),
                        new SqlParameter("pTelefs_Reporta", Types.VARCHAR),
                        new SqlParameter("pCve_Usuario", Types.VARCHAR),
                        new SqlParameter("pid_ajustador", Types.NUMERIC),
                        new SqlParameter("pFH_Reportado", Types.DATE),
                        new SqlParameter("pFH_Ocurrido", Types.DATE),
                        new SqlParameter("pFH_Asignacion", Types.DATE),
                        new SqlParameter("pFH_Cita", Types.DATE),
                        new SqlParameter("pFH_Contacto", Types.DATE),
                        new SqlParameter("pFH_Terminacion", Types.DATE),
                        new SqlParameter("pB_Cia_Respon", Types.VARCHAR),
                        new SqlParameter("pId_Cia_Aseg_Resp", Types.VARCHAR),
                        new SqlParameter("pId_Causa_Sin", Types.VARCHAR),
                        new SqlParameter("pCveL_Lugar_Ajust", Types.VARCHAR),
                        new SqlParameter("pCveL_T_Resp", Types.VARCHAR),
                        new SqlParameter("pCve_Term_Ajust", Types.VARCHAR),
                        new SqlParameter("pB_Fuga_Terc_Resp", Types.VARCHAR),
                        new SqlParameter("pcve_t_perdida", Types.VARCHAR),
                        new SqlParameter("pPlaca", Types.VARCHAR),
                        new SqlParameter("pEstimacionInf", Types.VARCHAR),
                        new SqlParameter("pPlacaAjusta", Types.VARCHAR),
                        new SqlParameter("pId_Cod_Resp", Types.NUMERIC),
                        new SqlParameter("pDesc_Codigo", Types.VARCHAR))
	                .returningResultSet("p_result_cursor",
	                        new BeanPropertyRowMapper<PolicyResponse>(PolicyResponse.class));
			
			final SqlParameterSource parameter = new MapSqlParameterSource()
					.addValue("pId_Reporte_sin", null)
					.addValue("pNum_Poliza", report.getPolicy())
					.addValue("pId_Lin_Negocio", 1) //TODO default
					.addValue("pId_Inciso", report.getPolicyNumber())// TODO validar si se puede usar report.getPolicyNumber()
					.addValue("pCve_Estado", report.getAddress().getState())
					.addValue("pCve_Ciudad", report.getAddress().getCity())
					.addValue("pUbicacion", report.getAddress().getStreet() 
							+ " " + report.getAddress().getExteriorNumber())
					.addValue("pColonia", report.getAddress().getColony())
					.addValue("pTx_Siniestro", report.getAttentionStatement().getStatementDescription() + "\n" + report.getAttentionStatement().getObservations())
		            .addValue("pNom_Reporta", report.getReportPersonName() + " " + report.getReportPersonLastName() + " " + report.getReportPersonMotherLastName())
		            .addValue("pNom_Conductor", report.getAttentionClaimData().getDriverName())
		            .addValue("pEdad_Cond", getAge(report.getAttentionInsuredVehicle().getVehicle().getDriver().getPerson().getBirthDate()))
		            .addValue("pcve_Sexo_Cond", report.getAttentionInsuredVehicle().getVehicle().getDriver().getPerson().getGender())
		            .addValue("pid_giro_ocup", null)
		            .addValue("pNum_lic_cond", null)
		            .addValue("pcvel_t_lic_cond", null)
		            .addValue("pf_venc_lic_cond", null)
		            .addValue("pid_taller_asig", null) //TODO "service_type": "repaircenterservice"
		            .addValue("pCodigo_Postal", report.getAddress().getZipCode())
		            .addValue("pid_colonia", null)
		            .addValue("pTelefs_Reporta", report.getReportPersonPhone())
		            .addValue("pCve_Usuario", "SPVCABIN") //TODO catalogo
		            .addValue("pid_ajustador", 1122) //TODO catalogo
		            .addValue("pFH_Reportado", report.getDateCreation())
		            .addValue("pFH_Ocurrido", report.getAttentionTheftData().getRobberyDate() == null 
		            	? report.getDateCreation(): report.getAttentionTheftData().getRobberyDate())
		            .addValue("pFH_Asignacion", report.getDateCreation()) //TODO 
		            .addValue("pFH_Cita", null) //TODO report.getAttentionServices().get(0).getAppointment().getDateTime()
		            .addValue("pFH_Contacto", report.getAttentionDate())
		            .addValue("pFH_Terminacion", new Date()) //TODO revisar
		            .addValue("pB_Cia_Respon", "F")//TODO participó compañia de seguros S o N
		            .addValue("pId_Cia_Aseg_Resp", null)//TODO report.getAttentionThirdAutos().get(0).getThirdAutoInsuranceData().getInsuranceCompany()
		            .addValue("pId_Causa_Sin", 277)//TODO causa del siniestro de donde lo saco?
		            .addValue("pCveL_Lugar_Ajust", "TRAN") //TODO CITA VIST TRAN CRUC
		            .addValue("pCveL_T_Resp", "RESP") //TODO RESP AFCT
		            .addValue("pCve_Term_Ajust", "CE") //TODO diferente si es afectado o responsable CE EONA ROC LEGA NOLOC CANC RECH DUPLI TRAN PEN  O EOT EOC EOAT EOAC
		            .addValue("pB_Fuga_Terc_Resp", "F") //TODO responsable se dio a la fuga?
		            .addValue("pcve_t_perdida", "P")//TODO P o T total o parcial
		            .addValue("pPlaca", report.getAttentionStatement().getVehicleData().getPlates()) //TODO placas que dio por telefono
		            .addValue("pEstimacionInf", null) //TODO Estimacion inicial
		            .addValue("pPlacaAjusta", report.getAttentionStatement().getVehicleData().getPlates());
			final List<PolicyResponse> lstCallResponse =  (List<PolicyResponse>) simpleJdbcCall.execute(parameter).get("pCursor");

		} catch (ResourceNotFoundException e) {
			throw e;
		} catch (Exception e) {
			LOG.error("-- getPolicy()", e);
			throw new GenericException(e.getMessage());	
		}
	}

	private long getAge(Date birthDate) {
		LocalDate localBirthDate = birthDate.toLocalDate();
		long years = ChronoUnit.YEARS.between(localBirthDate, LocalDate.now());
		return years;
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
