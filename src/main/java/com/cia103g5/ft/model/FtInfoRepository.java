package com.cia103g5.ft.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FtInfoRepository extends JpaRepository<FtVO, Integer> {

	// 根據 ftId 查找對應的占卜師資料
	Optional<FtVO> findByFtId(Long ftId);

	// 根據 status 查找所有尚未啟用的占卜師
	List<FtVO> findByStatus(Integer status);

	// 根據 ftRank 查找對應等級的占卜師
	List<FtVO> findByFtRank(Integer ftRank);

	// 根據是否可以發布 (canPost = true) 查找占卜師
	List<FtVO> findByCanPostTrue();

	// 根據暱稱部分關鍵字進行模糊查詢
	List<FtVO> findByNicknameContaining(String keyword);

	// 查詢狀態為停權且停權結束時間已過的占卜師
	List<FtVO> findByStatusAndActionEndedAtBefore(Integer status, LocalDateTime currentTime);
}
