package com.cia103g5.mem.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository	
public interface MemberInfoRepository extends JpaRepository<MemberInfo, Integer	>{

	Optional<MemberInfo> findByAccount(String account);
}
