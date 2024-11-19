package com.cia103g5.violation.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ft_violation_record")
public class FtVioRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成主鍵
	@Column(name = "ft_violation_no")
	private Integer ftVioRecordNo;
	
	@OneToOne
	@JoinColumn(name = "ft_id", referencedColumnName = "ft_id", nullable = false)
	@Column(name = "ft_id")
	private Integer ftId;
	
	@OneToOne
	@JoinColumn(name = "violation_type_no", referencedColumnName = "violation_type_no", nullable = false)
	@Column(name = "violation_type_no")
	private String vioType;
	
	@Column(name = "violated_at", insertable = false, updatable = false)
	private Date violatedAt;
	
	@Column(name = "violation_desc")
	private String vioDesc;
	
	@Column(name = "punishment")
	private String punishment;
	
	@Column(name = "status")
	private Integer status;
	
	
	
}
