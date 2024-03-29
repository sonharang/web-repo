package org.yedam.service.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yedam.common.DataSource;
import org.yedam.service.MemberService;
import org.yedam.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	DataSource dataSource = DataSource.getInstance();
	Connection conn = dataSource.getConnection();
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
public List<MemberVO> memberList() {
		List<MemberVO> members = new ArrayList<>();
		MemberVO vo;
		String sql = "SELECT * FROM MEMBER2";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMid(rs.getString("MID"));
				vo.setPass(rs.getString("PASS"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				members.add(vo);
			}
				rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return members;
	}

	private void close() {
		try {
			if(psmt != null)psmt.close();
			if(conn != null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addMember(MemberVO vo) {
		String sql = "insert into member2 values( ?, ?, ?, ?)";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getMid());
			psmt.setString(2,vo.getPass());
			psmt.setString(3,vo.getName());
			psmt.setString(4,vo.getPhone());
			
			int r = psmt.executeUpdate(); //반환값은 데이터처리 건수.
			if(r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close();
		}
		
		return false;
	}
	
	
	@Override
	public boolean modMember(MemberVO vo) {
		String sql = "update member2 set pass = ?,name = ?, phone = ? where mid = ?";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getPass());
			psmt.setString(2,vo.getName());
			psmt.setString(3,vo.getPhone());
			psmt.setString(4,vo.getMid());
			
			int r = psmt.executeUpdate(); //반환값은 데이터처리 건수.
			if(r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close();
		}
		
		return false;
	}
	@Override
	public boolean delMember(MemberVO vo) {
		String sql = "delete from member2 where mid = ? pass = ? name = ? phone = ?" ;
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,vo.getMid());
			psmt.setString(2,vo.getPass());
			psmt.setString(3,vo.getName());
			psmt.setString(4,vo.getPhone());
			
			int r = psmt.executeUpdate(); //반환값은 데이터처리 건수.
			if(r == 1 ) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally {
			close();
		}
		
		return false;
	}
}

