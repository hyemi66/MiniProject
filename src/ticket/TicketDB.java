package ticket;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dbc.DBConnection;
import movie.MovieDTO;

public class TicketDB {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	ArrayList<TicketDTO> list;
	TicketDTO dto;
	
	public TicketDB() {
		try {
			con = DBConnection.getConnection();
		} catch(Exception e) { e.printStackTrace(); }
	}
	
	public void ticketing(TicketDTO dto) {
		sql = "insert into ticket values(?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dto.getTic_id());
			pstmt.setString(2, dto.getTic_name());
			pstmt.setString(3, dto.getTic_time());
			pstmt.setString(4, dto.getTic_place());
			pstmt.setString(5, dto.getTic_area());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<TicketDTO> check(String tic_id) {
		sql = "select * from ticket where tic_id = ?";
		list = new ArrayList<>();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tic_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto = new TicketDTO();
				dto.setTic_id(tic_id);
				dto.setTic_name(rs.getString("tic_name"));
				dto.setTic_time(rs.getString("tic_time"));
				dto.setTic_place(rs.getString("tic_place"));
				dto.setTic_area(rs.getString("tic_area"));
				
				list.add(dto);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void delete(String tic_id) {
		sql = "delete from ticket where tic_id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, tic_id);
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
