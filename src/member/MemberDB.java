package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbc.DBConnection;

public class MemberDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	
	public MemberDB() {
		try {
			con = DBConnection.getConnection();
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public int checkId(String mem_id) {
		int result = 0;
		sql = "select * from member where mem_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(mem_id.equals(rs.getString("mem_id"))) {
					result = 1;
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void insertM(MemberDTO dto) {
		sql = "insert into member(mem_id, mem_pwd, mem_name, mem_phone) values(?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getMem_id());
			pstmt.setString(2, dto.getMem_pwd());
			pstmt.setString(3, dto.getMem_name());
			pstmt.setString(4, dto.getMem_phone());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int login(String mem_id, String mem_pwd) {
		int result = 0;
		sql = "select * from member where mem_id = ? and mem_pwd = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setString(2, mem_pwd);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(mem_id.equals(rs.getString("mem_id")) && mem_pwd.equals(rs.getString("mem_pwd"))) {
					result = 1;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void changePwd(String mem_id, String mem_pwd) {
		sql = "update member set mem_pwd = ? where mem_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_pwd);
			pstmt.setString(2, mem_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changeName(String mem_id, String mem_name) {
		sql = "update member set mem_name = ? where mem_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_name);
			pstmt.setString(2, mem_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void changePhone(String mem_id, String mem_phone) {
		sql = "update member set mem_phone = ? where mem_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_phone);
			pstmt.setString(2, mem_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteM(String mem_id) {
		sql = "delete from member where mem_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
