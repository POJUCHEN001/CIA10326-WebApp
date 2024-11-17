package com.cia103g5.mem.service;

import javax.security.auth.login.AccountNotFoundException;

import com.cia103g5.mem.model.Member_info;
import com.cia103g5.mem.model.Member_infoDAOJDBCImpl;
import com.cia103g5.mem.model.Member_infoDAO_interface;

public class Member_infoService {

	private Member_infoDAO_interface dao;

	public Member_infoService() {
		dao = new Member_infoDAOJDBCImpl();
	}

	//	註冊會員
	public Member_info registerMember(Member_info member) throws Exception {	
		checkRegistInfo(member);
		
		if (isAccountExist(member.getAccount())) {
//            throw new Exception("帳號已存在，請使用其他帳號註冊");
        }
		
		dao.insert(member);
		return member;
	}
	
//	驗證會員登入
	public Member_info login(String account, String password) throws  Exception {
	    Member_info member = dao.findByAccount(account);

	    // 驗證帳號是否存在
	    if (member == null) {
	        throw new  AccountNotFoundException("此帳號不存在");
	    }
	    
	    // 驗證密碼是否正確
	    if (!member.getPassword().equals(password)) {
	        throw new Exception("密碼不正確");
	    }
	    	    
	    return member;
	}
	
	public Member_info updateMember(String name, String nickname, Integer gender, String email) {

		Member_info mem = new Member_info();
		mem.setName(name);
		mem.setNickname(nickname);
		mem.setGender(gender);
		mem.setEmail(email);

		dao.update(mem);
		
		return mem;
	}

	public void deleteMember(Integer mem_id) {
		dao.delete(mem_id);
	}

	public Member_info getOneMember(Integer mem_id) {
		return dao.findByPK(mem_id);
	}
	
	//	檢查註冊資訊
	private void checkRegistInfo(Member_info member) throws Exception {	

		if (member.getAccount() == null || member.getAccount().trim().isEmpty()) {
			throw new Exception("帳號不得為空");
		}
		if (member.getPassword() == null || member.getPassword().trim().isEmpty()) {
			throw new Exception("密碼不得為空");
		}
		if (member.getName() == null || member.getName().trim().isEmpty()) {
			throw new Exception("姓名不得為空");
		}
		if (member.getEmail() == null || member.getEmail().trim().isEmpty()) {
			throw new Exception("EMAIL不得為空");
		}
		if (member.getGender() == null) {
			throw new Exception("性別要選擇");
		}
	}
	
	//	檢查帳號是否存在
	public boolean isAccountExist(String account) {	
//		Member_info member = dao.findByAccount(account);
//		return member != null;
		return dao.findByAccount(account) != null;
	}
	
	
}
