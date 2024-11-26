package com.cia103g5.violation.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import groovy.transform.ToString;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ToString
@Entity
@Table(name = "violation_index")
public class ViolationIndex implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成主鍵
	@Column(name = "violation_type_no")
	private Integer vioTypeNo;
	
	@Column(name = "violation_type_no")
	private String vioType;
	
	
	@Column(name = "created_at", insertable = false, updatable = false)
	private Timestamp createdAt;
	
	
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	

	public ViolationIndex() {
		super();
	}


	public Integer getVioTypeNo() {
		return vioTypeNo;
	}


	public void setVioTypeNo(Integer vioTypeNo) {
		this.vioTypeNo = vioTypeNo;
	}


	public String getVioType() {
		return vioType;
	}


	public void setVioType(String vioType) {
		this.vioType = vioType;
	}


	public Timestamp getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}


	public Timestamp getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
