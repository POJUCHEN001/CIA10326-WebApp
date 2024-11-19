package com.cia103g5.violation.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViolationService {

	@Autowired
	private ViolationRepository repository;

	//	新曾違規目錄
	public ViolationIndex addViolation(ViolationIndex violationIndex) {
		return repository.save(violationIndex);
	}
	
	//	修改違規目錄
	public ViolationIndex  updateViolation(ViolationIndex violationIndex) {
		return repository.save(violationIndex);
	}
	
	//	刪除違規目錄
	public void deleteViolation(Integer vioTypeNo) {
		if(repository.existsById(vioTypeNo))
			repository.deleteById(vioTypeNo);
	}
	
	//	查詢單一違規目錄
	public ViolationIndex getOneViolationIndex(Integer vioTypeNo) {
		Optional<ViolationIndex> optional = repository.findById(vioTypeNo);
		return optional.orElse(null);
	}
	
	//	查詢全部違規目錄
	public List<ViolationIndex> getAllViolationIndex(){
		return repository.findAll();
	}
	
	
	
}
