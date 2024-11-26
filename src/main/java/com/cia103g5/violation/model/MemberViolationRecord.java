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

import com.cia103g5.member.model.MemberVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member_violation_record")
public class MemberViolationRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主鍵
	@Column(name = "violation_record_no")
	private Integer vioRecordNo;
	
	@OneToOne
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id", nullable = false)
	@Column(name = "mem_id")
	private MemberVO memId;
	
	@OneToOne
	@JoinColumn(name = "violation_type_no", referencedColumnName = "violation_type_no", nullable = false)
	@Column(name = "violation_type_no")
	private String vioType;
	
	@Column(name = "violated_time", insertable = false, updatable = false)
	private Date violatedAt;
	
	@Column(name = "violation_desc")
	private String violatedDesc;
	
	@Column(name = "punishment")
	private String punishment;
	
	@Column(name = "punish_date")
	private Date punishDate;
	
	@Column(name = "status")
	private Integer status;
	
	

}
