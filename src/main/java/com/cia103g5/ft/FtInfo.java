package com.cia103g5.ft;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Ft_info")
public class FtInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ft_id")
	private Integer ftId;
	
	@Id
	@Column(name="mem_id")
	private Integer memId;
	
	@Column(name="ft_rank")
	private Integer ftRank;
	
	@Column(name="company_name")
	private String company_name;
	
	@Column(name="profile_photo")
	private byte[] profile_photo;
	
	@Column(name="registered_at")
	private Date registeredAt;
	
	@Column(name="approved_at")
	private Date approvedAt;
	
	@Column(name="status")
	private Integer status;
	
	@Column(name="business_photo")
	private byte[] businessPhoto;
	
	@Column(name="business_no")
	private String businessNo;
	
	@Column(name="nickname")
	private String nickname;
	
	@Column(name="can_post")
	private Integer canPost;	//	時間還是狀態?
	
	@Column(name="can_rev")
	private Integer canRev;
	
	@Column(name="can_sell")
	private Integer canSell;
	
	@Column(name="action_started_at")
	private Date actionStartedAt;
	
	@Column(name="action_ended_at")
	private Date actionEndedAt;
	
	@Column(name="bank_account")
	private Integer bankAccount;
	
	
	
	
	
}
