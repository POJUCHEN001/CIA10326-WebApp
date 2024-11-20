package com.cia103g5.member.model;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberInfoService {

	@Autowired
	private MemberInfoRepository repository;

	// 新增會員
	public void addMember(String account, String password, String name, String email, Integer gender, MultipartFile photo) {
        try {
            MemberInfo newMember = new MemberInfo();
            newMember.setAccount(account);
            newMember.setPassword(password);
            newMember.setName(name);
            newMember.setEmail(email);
            newMember.setGender(gender);
            if (photo != null && !photo.isEmpty()) {
                newMember.setPhoto(photo.getBytes());
            }
            repository.save(newMember);
        } catch (IOException e) {
            throw new RuntimeException("照片上傳失敗：" + e.getMessage(), e);
        }
    }
	
	// 註冊會員
	public MemberInfo registMembers(MemberInfo member) throws Exception{
		checkRegistInfo(member);
		if(isAccountExist(member.getAccount())) {
			throw new Exception ("帳號已存在，請使用其他帳號進行註冊");
		}
		return repository.save(member);
	}

	// 更新會員
	public void updateMember(MemberInfo memberInfo) {
		repository.save(memberInfo);
	}

	// 根據 ID 查詢會員
	public MemberInfo findMemberById(Integer memId) {
		return repository.findById(memId).orElseThrow(() -> new RuntimeException("會員不存在，ID: " + memId));
	}

	// 根據帳號查詢會員
	public MemberInfo findMemberByAccount(String account) {
		return repository.findByAccount(account).orElseThrow(() -> new RuntimeException("會員帳號不存在，Account: " + account));
	}

	// 查詢所有會員
	public List<MemberInfo> getAllMembers() {
		return repository.findAll();
	}

	// 更新會員照片
//	public void updateMemberPhoto(Integer memId, byte[] photo) {
//		MemberInfo member = findMemberById(memId);
//		member.setPhoto(photo);
//		repository.save(member);
//	}
	public void updateMemberPhoto(Integer memId, MultipartFile photo) {
        try {
            MemberInfo member = findMemberById(memId);
            if (photo != null && !photo.isEmpty()) {
                member.setPhoto(photo.getBytes());
            }
            repository.save(member);
        } catch (IOException e) {
            throw new RuntimeException("照片處理失敗：" + e.getMessage(), e);
        }
    }
	
	// 檢查註冊資訊
    private void checkRegistInfo(MemberInfo member) throws Exception {
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

    // 檢查帳號是否存在
    public boolean isAccountExist(String account) {
        return repository.findByAccount(account) != null;
    }

}
