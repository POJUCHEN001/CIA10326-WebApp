package com.cia103g5.member.model;

import java.sql.Date;


public class Member_info implements java.io.Serializable {
	

	private static final long serialVersionUID = 1L;

	private Integer mem_id;
	private Integer ft_id;
	private String name;
	private String account;
	private String password;
	private String email;
	private Integer email_state;
	private Date registered_at;
	private byte[] photo;
	private Integer gender;
	private String nickname;
	private Integer status;
	private Integer points;

	public Member_info() {
		super();
	}

	public Integer getMem_id() {
		return mem_id;
	}

	public void setMem_id(Integer mem_id) {
		this.mem_id = mem_id;
	}

	public Integer getFt_id() {
		return ft_id;
	}

	public void setFt_id(Integer ft_id) {
		this.ft_id = ft_id;
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

	public Integer getEmail_state() {
		return email_state;
	}

	public void setEmail_state(Integer email_state) {
		this.email_state = email_state;
	}

	public Date getRegistered_at() {
		return registered_at;
	}

	public void setRegistered_at(Date registered_at) {
		this.registered_at = registered_at;
	}

	public byte[] getPhoto() {
		return photo;
	}
	
	public void setPhoto(byte[] photo) {
        this.photo = photo;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
}
