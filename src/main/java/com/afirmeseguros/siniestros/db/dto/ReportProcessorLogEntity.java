package com.afirmeseguros.siniestros.db.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "report_processor_log", schema = "siniestros")
public class ReportProcessorLogEntity {

	@Id
	@SequenceGenerator(name = "report_processor_log_pk_seq", sequenceName = "siniestros.report_processor_log_pk_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "report_processor_log_pk_seq")
	private Long id;

	private String externalId;

	private Date createdDate;

	private String jsonData;

}
