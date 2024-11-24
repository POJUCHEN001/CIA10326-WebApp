package com.cia103g5.member.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "member_info")
public class MemberVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成主鍵
	@Column(name = "mem_id")
	private Integer memId;

//	@Column(name = "ft_id")
//	private Integer ftId;

	@Column(name = "name", nullable = false) // 名稱必填
	@NotEmpty(message = "姓名請勿空白")
	@Pattern(regexp = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$", message = "姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間")
	private String name;

	@Column(name = "account", nullable = false, unique = true, length = 50) // 帳號唯一且必填
	private String account;

	@Column(name = "password", nullable = false, length = 20)
	@NotEmpty(message = "密碼請勿空白")
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,20}$", message = "密碼必須包含大小寫字母及數字，且長度需在6到20字元之間")
	private String password;

	@Column(name = "email", nullable = false, unique = true) // email 唯一且必填
	@NotEmpty(message = "E-mail請勿空白")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "請輸入有效的 Email 格式")
	private String email;

	@Column(name = "email_state")
	private Integer emailState;

	@Column(name = "registered_time")
	private Date registeredTime;

	@Column(name = "photo")
	private byte[] photo;

	@Column(name= "phone")
    private String phone;

	@Column(name = "gender")
	@Min(value = 0, message = "性別只能為 0（不公開）、1（男）或 2（女）")
	@Max(value = 2, message = "性別只能為 0（不公開）、1（男）或 2（女）")
	private Integer gender; // 0:不公開 1:男 2:女

	@Column(name = "nickname", length = 50)
	private String nickname;

	@Column(name = "status")
	private Integer status; // 0啟用 1停用 2註銷

	@Column(name = "points")
	private Integer points;

	@Column(name = "bank_account", length = 50)
	private String bankAccount;

	

}
