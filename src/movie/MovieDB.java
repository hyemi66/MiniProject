package movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbc.DBConnection;

public class MovieDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	ArrayList<MovieDTO> list;
	MovieDTO dto;
	
	public MovieDB() {
		try {
			con = DBConnection.getConnection();
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public ArrayList<MovieDTO> movieList() {
		sql = "select * from movie";
		list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setMov_name(rs.getString("mov_name"));
				dto.setMov_time(rs.getString("mov_time"));
				dto.setMov_area(rs.getString("mov_area"));
				dto.setMov_place(rs.getString("mov_place"));
				dto.setMov_seat(rs.getInt("mov_seat"));
				
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public ArrayList<MovieDTO> choiceM(String mov_name) {
		sql = "select * from movie where mov_name = ?";
		list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mov_name);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setMov_time(rs.getString("mov_time"));
				dto.setMov_area(rs.getString("mov_area"));
				dto.setMov_place(rs.getString("mov_place"));
				dto.setMov_seat(rs.getInt("mov_seat"));
				
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public ArrayList<MovieDTO> pickM(String mov_name, String mov_place) {
		sql = "select * from movie where mov_name = ? and mov_place = ?";
		list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mov_name);
			pstmt.setString(2, mov_place);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto = new MovieDTO();
				dto.setMov_name(rs.getString("mov_name"));
				dto.setMov_time(rs.getString("mov_time"));
				dto.setMov_area(rs.getString("mov_area"));
				dto.setMov_place(rs.getString("mov_place"));
				dto.setMov_seat(rs.getInt("mov_seat"));
				
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void seatCount(MovieDTO dto) {
		sql = "update movie set mov_seat = ? where mov_name = ? and mov_place = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dto.getMov_seat());
			pstmt.setString(2, dto.getMov_name());
			pstmt.setString(3, dto.getMov_place());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
