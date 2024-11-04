package com.cia103g5.mem.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.Util;

public class Member_infoDAOJDBCImpl implements Member_infoDAO_interface {

	private static final String INSERT_MEM = "INSERT INTO Member_info (account, password, name, email, gender, photo) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_MEM = "UPDATE Member_info SET name=?, nickname=?, gender=?, email=?  WHERE mem_id = ?";
	private static final String DELETE_MEM = "DELETE FROM Member_info where mem_id = ?";
	private static final String FIND_BY_PK = "SELECT * FROM Member_info where mem_id = ?";
	private static final String SETPHOTO = "UPDATE Member_info SET photo=? where mem_id = ?";
	private static final String FINDBYACCOUNT = "SELECT * FROM Member_info where account = ?";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(Member_info Member_info) { // 新增會員 (註冊會員)
		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_MEM);

			// 會員帳號、密碼、姓名、email、性別
			pstmt.setString(1, Member_info.getAccount());
			pstmt.setString(2, Member_info.getPassword());
			pstmt.setString(3, Member_info.getName());
			pstmt.setString(4, Member_info.getEmail());
			pstmt.setInt(5, Member_info.getGender());
			pstmt.setBytes(6, Member_info.getPhoto());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void update(Member_info Member_info) { // 修改會員基本資料
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_MEM);

			// 會員姓名、暱稱、性別、email
			pstmt.setString(1, Member_info.getName());
			pstmt.setString(2, Member_info.getNickname());
			pstmt.setInt(3, Member_info.getGender());
			pstmt.setString(4, Member_info.getEmail());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public void delete(Integer mem_id) { // 刪除會員資料
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_MEM);

			pstmt.setInt(1, mem_id);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	@Override
	public Member_info findByPK(Integer mem_id) { // 單筆查詢 (會員基本資料)
		Member_info mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, mem_id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new Member_info();
				mem.setMem_id(rs.getInt("mem_id"));
				mem.setName(rs.getString("name"));
				mem.setNickname(rs.getString("nickname"));
				mem.setAccount(rs.getString("account"));
				mem.setPassword(rs.getString("password"));
				mem.setEmail(rs.getString("email"));
				mem.setEmail_state(rs.getInt("email_state"));
				mem.setGender(rs.getInt("gender"));
				mem.setPhoto(rs.getBytes("photo"));
				mem.setPoints(rs.getInt("point"));
				mem.setRegistered_at(rs.getDate("registered_at"));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return mem;
	}
	
//	public Member_info findByAccount(String account, String password) { // 單筆查詢 (會員基本資料)
//		Member_info mem = null;
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			pstmt = con.prepareStatement(FINDBYACCOUNT);
//			pstmt.setString(1, account);
//			rs = pstmt.executeQuery();
//
//			while (rs.next()) {
//				mem = new Member_info();
//				mem.setMem_id(rs.getInt("mem_id"));
//				mem.setName(rs.getString("name"));
//				mem.setNickname(rs.getString("nickname"));
//				mem.setAccount(rs.getString("account"));
//				mem.setPassword(rs.getString("password"));
//				mem.setEmail(rs.getString("email"));
//				mem.setEmail_state(rs.getInt("email_state"));
//				mem.setGender(rs.getInt("gender"));
//				mem.setPhoto(rs.getBytes("photo"));
//				mem.setPoints(rs.getInt("point"));
//				mem.setRegistered_at(rs.getDate("registered_at"));
//			}
//
//		} catch (SQLException se) {
//			se.printStackTrace();
//		} finally {
//			closeResources(con, pstmt, rs);
//		}
//		return mem;
//	}

	public void insert(byte[] photo) {	// 新增圖片 (會員大頭照)
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(SETPHOTO);
			byte[] pic = getPictureByteArray("items/FC_Barcelona.png"); // 方法
			pstmt.setBytes(3, pic);
			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			closeResources(con, pstmt, null);
		}
	}

	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] photo = fis.readAllBytes();
		fis.close();
		return photo;
	}

	@Override
	public Member_info findByAccount(String account) {		//	查會員帳號
		Member_info mem = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FINDBYACCOUNT);
			pstmt.setString(1, account);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				mem = new Member_info();
				mem.setMem_id(rs.getInt("mem_id"));
				mem.setName(rs.getString("name"));
				mem.setNickname(rs.getString("nickname"));
				mem.setAccount(rs.getString("account"));
				mem.setPassword(rs.getString("password"));
				mem.setEmail(rs.getString("email"));
				mem.setEmail_state(rs.getInt("email_state"));
				mem.setGender(rs.getInt("gender"));
				mem.setPhoto(rs.getBytes("photo"));
				mem.setPoints(rs.getInt("point"));
				mem.setRegistered_at(rs.getDate("registered_at"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(con, pstmt, rs);
		}
		return mem;
	}
	
	//	資源關閉
	private void closeResources(Connection con, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException se) {
				se.printStackTrace(System.err);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace(System.err);
			}
		}
	}
}
