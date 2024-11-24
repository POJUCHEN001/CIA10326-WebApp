package com.cia103g5.member.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository	
public interface MemberInfoRepository extends JpaRepository<MemberVO, Integer	>{

	Optional<MemberVO> findByAccount(String account);
	
	
}
