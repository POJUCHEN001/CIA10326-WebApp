package com.cia103g5.ft.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class FtInfoService {

	@Autowired
	private FtInfoRepository repository;

	public FtVO saveMember(FtVO ft) {
		return repository.save(ft);
	}

	// 新增占卜師
	public FtVO createFtInfo(FtVO ftInfo) {
		// 初始化狀態及權限
		ftInfo.setStatus(0); // 初始為待審核狀態
		ftInfo.setCanPost(0);
		ftInfo.setCanRev(0);
		ftInfo.setCanSell(0);
//		ftInfo.setRegisteredAt(java.sql.Date.valueOf(LocalDate.now()));	//	資料庫自動插入當前時間

		return repository.save(ftInfo);
	}

	// 修改占卜師資料
	public FtVO updateFtInfo(Integer ftId, FtVO updatedInfo) {
		FtVO ftInfo = repository.findById(ftId).orElseThrow(() -> new RuntimeException("占卜師資料不存在"));

		// 更新字段
		ftInfo.setFtRank(updatedInfo.getFtRank());
		ftInfo.setCompany_name(updatedInfo.getCompany_name());
		ftInfo.setProfile_photo(updatedInfo.getProfile_photo());
//		ftInfo.setApprovedAt(updatedInfo.getApprovedAt()); 
		ftInfo.setStatus(updatedInfo.getStatus());
		ftInfo.setBusinessPhoto(updatedInfo.getBusinessPhoto());
		ftInfo.setBusinessNo(updatedInfo.getBusinessNo());
		ftInfo.setNickname(updatedInfo.getNickname());
		ftInfo.setCanPost(updatedInfo.getCanPost());
		ftInfo.setCanRev(updatedInfo.getCanRev());
		ftInfo.setCanSell(updatedInfo.getCanSell());
		ftInfo.setActionStartedDay(updatedInfo.getActionStartedDay());
		ftInfo.setActionEndedDay(updatedInfo.getActionEndedDay());
		ftInfo.setBankAccount(updatedInfo.getBankAccount());

		return repository.save(ftInfo);
	}

	// 查詢單筆占卜師資料
	public FtVO getFtInfoById(Integer ftId) {
		return repository.findById(ftId).orElseThrow(() -> new RuntimeException("占卜師資料不存在"));
	}

	// 查詢全部占卜師資料
	public List<FtVO> getAllFtInfos() {
		return repository.findAll();
	}

	
	// 根據 memId 獲取占卜師資料
	public FtVO getFtInfoByMemId(Integer memId) {
		return repository.findById(memId).orElseThrow(() -> new RuntimeException("占卜師資料不存在"));
	}

	// 啟用占卜師會員
	public void activateFtInfo(Integer memId) {
		FtVO ftInfo = getFtInfoByMemId(memId);

		// 更新狀態為啟用
		ftInfo.setStatus(1);

		// 恢復默認可用權限
		ftInfo.setCanPost(1);
		ftInfo.setCanRev(1);
		ftInfo.setCanSell(1);

		// 清除停權時間
		ftInfo.setActionStartedDay(null);
		ftInfo.setActionEndedDay(null);

		// 保存到資料庫
		repository.save(ftInfo);
	}

	// 檢查占卜師是否可以執行某操作
	public boolean canPerformAction(Integer memId, String actionType) {
		FtVO ftInfo = getFtInfoByMemId(memId);

		// 如果狀態為停權（0），則禁止操作
		if (ftInfo.getStatus() == 0) {
			return false;
		}

		// 當前時間
		Timestamp now = new Timestamp(System.currentTimeMillis());

		// 檢查可用時間範圍
		if (ftInfo.getActionStartedDay() != null && ftInfo.getActionEndedDay() != null) {

			// 將 java.sql.Date 強制轉換為 Timestamp
			Timestamp actionStartedAt = new Timestamp(ftInfo.getActionStartedDay().getTime());
			Timestamp actionEndedAt = new Timestamp(ftInfo.getActionEndedDay().getTime());

			if (now.before(actionStartedAt) || now.after(actionEndedAt)) {
				return false;
			}
		}

		// 根據操作類型檢查
		switch (actionType.toLowerCase()) {
		case "post": // 發文
			return ftInfo.getCanPost() == 1;

		case "resv": // 接受預約
			return ftInfo.getCanRev() == 1;

		case "sell": // 上架
			return ftInfo.getCanSell() == 1;

		default:
			throw new IllegalArgumentException("未知的操作類型: " + actionType);
		}
	}

	// 更新占卜師狀態為停權
	public void suspendFtInfo(Integer memId) {
		FtVO ftInfo = getFtInfoByMemId(memId);

		// 更新狀態為停權
		ftInfo.setStatus(0);
		ftInfo.setCanPost(0); // 禁止發文
		ftInfo.setCanRev(0); // 禁止接受預約
		ftInfo.setCanSell(0); // 禁止上架
		
		// 設定開始時間為當前日期
		ftInfo.setActionStartedDay(new java.sql.Date(System.currentTimeMillis()));

		// 設定結束時間為 3 天後
		ftInfo.setActionEndedDay(new java.sql.Date(System.currentTimeMillis() + 3L * 24 * 60 * 60 * 1000));

		repository.save(ftInfo);
	}

	// 定時檢查停權到期的占卜師並自動恢復
	@Scheduled(cron = "0 0 * * * *") // 每小時執行一次
	public void checkAndRestoreFtStatus() {
		LocalDateTime now = LocalDateTime.now();

		// 查詢所有狀態為停權且停權結束時間已過的占卜師
		List<FtVO> suspendedFtInfos = repository.findByStatusAndActionEndedAtBefore(0, now);

		for (FtVO ftInfo : suspendedFtInfos) {
			// 恢復占卜師狀態
			activateFtInfo(ftInfo.getFtId());
			System.out.println("占卜師 " + ftInfo.getFtId() + " 已自動解除停權");
		}
	}

}
