package com.cia103g5.memberviolation.model;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberVioService {
	
	@Autowired
	private MemberVioRepository repository;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	//	新稱會員違規紀錄
	public MemberVioRecord addMemberVioRecord(MemberVioRecord memberVioRecord) {
		repository.save(memberVioRecord);
		return memberVioRecord;
	}
	
	//	修改會員違規紀錄
	public MemberVioRecord updateMemberVioRecord(MemberVioRecord memberVioRecord) {
		repository.save(memberVioRecord);
		return memberVioRecord;
	}
	
	//	刪除會員違規紀錄
	public void deleteMemberVioRecord(Integer memId) {
		if (repository.existsById(memId))
		repository.deleteById(memId);
	}
	
	//	查詢單一會員違規紀錄
	public MemberVioRecord getMemberVioRecord(Integer memId) {
		Optional<MemberVioRecord> optional = repository.findById(memId);
		return optional.get();
	}
	
	//	查詢全部會員違規紀錄
	public List<MemberVioRecord> getAllMemberVioRecord(){
		return repository.findAll();
	}
	
	//	複合查詢
//	public List<MemberVioRecord> getAllMemberVioRecord(Map<String, String[]> map){
//		return ComppsiteQuery.getAll(map,sessionFactory.openSession());
//	}

}
