package com.cia103g5.ft.model;

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

@Entity
@Table(name = "ft_info")
public class FtVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) //	資料庫自增
	@Column(name = "ft_id")
	private Integer ftId;

	@OneToOne	// 與 MemberInfo 的一對一關係
	@JoinColumn(name = "mem_id", referencedColumnName = "mem_id", nullable = false)
	@Column(name = "mem_id")
	private MemberVO member; 

//	@OneToOne
	@Column(name = "ft_rank")	// 需要設, nullable = false?
	private Integer ftRank;

	@Column(name = "company_name", nullable = false)
	private String company_name;

	@Column(name = "profile_photo")
	private byte[] profile_photo;

	@Column(name = "registered_at", insertable = false, updatable = false)
	private Date registeredAt;

	@Column(name = "approved_at", insertable = false, updatable = false)
	private Date approvedAt;

	@Column(name = "status") // 0待審核或停用 1啟用占卜師 2永久停權
	private Integer status;

	@Column(name = "business_photo", nullable = false)
	private byte[] businessPhoto;

	@Column(name = "business_no", nullable = false)
	private String businessNo;

	@Column(name = "nickname")
	private String nickname;

	@Column(name = "can_post")
	private Integer canPost;	//	0停用/未啟用 1啟用

	@Column(name = "can_rev")
	private Integer canRev;		//	0停用/未啟用 1啟用

	@Column(name = "can_sell")
	private Integer canSell;	//	0停用/未啟用 1啟用

	@Column(name = "action_started_at")
	private Date actionStartedAt;	//	用Timestamp 可支持到年月日時分秒比較精準 對於停權與否的操作較為嚴謹

	@Column(name = "action_ended_at")
	private Date actionEndedAt;	//	用Timestamp 理由同上

	@Column(name = "bank_account")
	private Integer bankAccount;

	public Integer getFtId() {
		return ftId;
	}

	public void setFtId(Integer ftId) {
		this.ftId = ftId;
	}

	public MemberVO getMember() {
		return member;
	}

	public void setMember(MemberVO member) {
		this.member = member;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

}
