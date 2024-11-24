package com.cia103g5.memberviolation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberVioRepository extends JpaRepository<MemberViolationRecord, Integer>{

}
