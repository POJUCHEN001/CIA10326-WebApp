package com.cia103g5.ft.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "ft_grade")
public class FtGrade implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ft_rank")
	private Integer ftRank;

	@Column(name = "rank_name")
	private String rankName;
	

	public FtGrade() {
		super();
	}

	public Integer getFtRank() {
		return ftRank;
	}

	public void setFtRank(Integer ftRank) {
		this.ftRank = ftRank;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	
	
}
