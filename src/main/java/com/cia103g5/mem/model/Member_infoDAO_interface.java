package com.cia103g5.mem.model;

public interface Member_infoDAO_interface {

	public void insert(Member_info Member_info);

	public void update(Member_info Member_info);

	public void delete(Integer mem_id);		//	會員資料不會刪除 只有狀態會註記已註銷會員 此方法不需要存在

	public Member_info findByPK(Integer mem_id);
	
	public Member_info findByAccount(String account);

//	public List<Member_info> getAll();	

	// 萬用複合查詢(傳入參數型態Map)(回傳 List)
//	public List<Member_infoVO> getAll(Map<String, String[]> map); 

}
