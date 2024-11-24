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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

	@Column(name = "registered_time", insertable = false, updatable = false)
	private Date registeredTime;

	@Column(name = "approved_time", insertable = false, updatable = false)
	private Date approvedTime;

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

	@Column(name = "action_started_day")
	private Date actionStartedDay;	//	用Timestamp 可支持到年月日時分秒比較精準 對於停權與否的操作較為嚴謹

	@Column(name = "action_ended_day")
	private Date actionEndedDay;	//	用Timestamp 理由同上

	@Column(name = "bank_account")
	private Integer bankAccount;

	@Column( name = "intro")
	private String intro;
	
	@Column(name = "price")
	private Integer price;

	
	

}
