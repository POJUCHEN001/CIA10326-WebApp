package com.cia103g5.member.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mem_id")
    private Integer memId;

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
    
    @Column(name ="key")
    private String key;

    @Column(name = "registered_time")
    private Date registeredTime;
    
    @Column(name = "photo")
    private byte[] photo;

    @Column(name= "phone")
    private String phonenumber;

    @Column(name = "gender")
	@Min(value = 0, message = "性別只能為 0（不公開）、1（男）或 2（女）")
	@Max(value = 2, message = "性別只能為 0（不公開）、1（男）或 2（女）")
    private Integer gender;
    
	@Column(name = "nickname", length = 50)
    private String nickname;

	@Column(name = "points")
	private Integer points;
	
	@Column(name = "bank_account", length = 50)
	private String bankAccount;
	
	@Column(name = "status")
    private Integer status;
	
	// 建構子
	public MemberVO() {
		super();
	}

	public MemberVO(Integer memId,
			@NotEmpty(message = "姓名請勿空白") @Pattern(regexp = "^[(一-龥)(a-zA-Z0-9_)]{2,10}$", message = "姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間") String name,
			String account,
			@NotEmpty(message = "密碼請勿空白") @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{6,20}$", message = "密碼必須包含大小寫字母及數字，且長度需在6到20字元之間") String password,
			@NotEmpty(message = "E-mail請勿空白") @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "請輸入有效的 Email 格式") String email,
			String key, Integer emailState, Date registeredTime, byte[] photo, String phonenumber,
			@Min(value = 0, message = "性別只能為 0（不公開）、1（男）或 2（女）") @Max(value = 2, message = "性別只能為 0（不公開）、1（男）或 2（女）") Integer gender,
			String nickname, Integer points, String bankAccount, Integer status) {
		super();
		this.memId = memId;
		this.name = name;
		this.account = account;
		this.password = password;
		this.email = email;
		this.key = key;
		this.emailState = emailState;
		this.registeredTime = registeredTime;
		this.photo = photo;
		this.phonenumber = phonenumber;
		this.gender = gender;
		this.nickname = nickname;
		this.points = points;
		this.bankAccount = bankAccount;
		this.status = status;
	}
	

	// getter & setter
	public Integer getMemId() {
		return memId;
	}

	public void setMemId(Integer memId) {
		this.memId = memId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Integer getEmailState() {
		return emailState;
	}

	public void setEmailState(Integer emailState) {
		this.emailState = emailState;
	}

	public Date getRegisteredTime() {
		return registeredTime;
	}

	public void setRegisteredTime(Date registeredTime) {
		this.registeredTime = registeredTime;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", name=" + name + ", account=" + account + ", password=" + password
				+ ", email=" + email + ", key=" + key + ", emailState=" + emailState + ", registeredTime="
				+ registeredTime + ", photo=" + Arrays.toString(photo) + ", phonenumber=" + phonenumber + ", gender="
				+ gender + ", nickname=" + nickname + ", points=" + points + ", bankAccount=" + bankAccount
				+ ", status=" + status + "]";
	}
	

}
