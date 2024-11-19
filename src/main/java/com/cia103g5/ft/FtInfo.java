package com.cia103g5.ft;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cia103g5.mem.model.MemberInfo;


@Entity
@Table(name = "Ft_info")
public class FtInfo extends MemberInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ft_id")
	private Integer ftId;
	
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

	public Integer getFtId() {
		return ftId;
	}

	public void setFtId(Integer ftId) {
		this.ftId = ftId;
	}

	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public Integer getFtRank() {
		return ftRank;
	}

	public void setFtRank(Integer ftRank) {
		this.ftRank = ftRank;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public byte[] getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(byte[] profile_photo) {
		this.profile_photo = profile_photo;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Date getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(Date approvedAt) {
		this.approvedAt = approvedAt;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public byte[] getBusinessPhoto() {
		return businessPhoto;
	}

	public void setBusinessPhoto(byte[] businessPhoto) {
		this.businessPhoto = businessPhoto;
	}

	public String getBusinessNo() {
		return businessNo;
	}

	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getCanPost() {
		return canPost;
	}

	public void setCanPost(Integer canPost) {
		this.canPost = canPost;
	}

	public Integer getCanRev() {
		return canRev;
	}

	public void setCanRev(Integer canRev) {
		this.canRev = canRev;
	}

	public Integer getCanSell() {
		return canSell;
	}

	public void setCanSell(Integer canSell) {
		this.canSell = canSell;
	}

	public Date getActionStartedAt() {
		return actionStartedAt;
	}

	public void setActionStartedAt(Date actionStartedAt) {
		this.actionStartedAt = actionStartedAt;
	}

	public Date getActionEndedAt() {
		return actionEndedAt;
	}

	public void setActionEndedAt(Date actionEndedAt) {
		this.actionEndedAt = actionEndedAt;
	}

	public Integer getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(Integer bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	
	

	
}
