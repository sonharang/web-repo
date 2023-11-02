package co.yedam.student.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.yedam.common.DataSource;
import co.yedam.student.service.StudentVO;

public class StudentDAO {
	// connection 객체
	DataSource ds = DataSource.getInstance();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// method 구현
	public int insert(StudentVO vo) {
		String sql = "INSERT INTO STUDENT(STUDENT_ID, STUDENT_NAME, STUDENT_PASSWORD, "
				+ "STUDENT_DEPT, STUDENT_BIRTHDAY) VALUES(?, ?, ?, ?, ?)";
		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(vo.getStudentBirthday()));
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentId());
			psmt.setString(2, vo.getStudentName());
			psmt.setString(3, vo.getStudentPassword());
			psmt.setString(4, vo.getStudentDept());
			psmt.setString(5, sdf.format(vo.getStudentBirthday()));

			int r = psmt.executeUpdate();
			return r;
			// System.out.println("DB연결성공");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리가 된 건수가 없음 : 에러
	}

	public int update(StudentVO vo) {
		String sql = "UPDATE STUDENT SET STUDENT_NAME = ?, STUDENT_PASSWORD = ?, "
				+ "STUDENT_DEPT = NVL(?, STUDENT_DEPT),STUDENT_BIRTHDAY = ? WHERE STUDENT_ID = ?";
		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getStudentName());
			psmt.setString(2, vo.getStudentPassword());
			psmt.setString(3, vo.getStudentDept());
			psmt.setString(4, sdf.format(vo.getStudentBirthday()));
			psmt.setString(5, vo.getStudentId());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리가 된 건수가 없음 : 에러
	}

	public int delete(String sid) {
		String sql = "DELETE FROM STUDENT WHERE STUDENT_ID = ?";
		conn = ds.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sid);

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리가 된 건수가 없음 : 에러
	}

	public List<StudentVO> studentList() {
		List<StudentVO> students = new ArrayList<>();
		StudentVO vo;
		String sql = "SELECT * FROM STUDENT ORDER BY STUDENT_DEPT,STUDENT_NAME";
		conn = ds.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new StudentVO();
				vo.setStudentId(rs.getString("student_id"));
				vo.setStudentName(rs.getString("student_name"));
				vo.setStudentPassword(rs.getString("student_password"));
				vo.setStudentDept(rs.getString("student_dept"));
				vo.setStudentBirthday(rs.getDate("student_birthday"));
				students.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return students; // 처리가 된 건수가 없음 : 에러
	}

	public StudentVO select(String sid) {
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_ID=?";
		conn = ds.getConnection();
		StudentVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, sid);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new StudentVO();
				vo.setStudentId(rs.getString("student_id"));
				vo.setStudentName(rs.getString("student_name"));
				vo.setStudentPassword(rs.getString("student_password"));
				vo.setStudentDept(rs.getString("student_dept"));
				vo.setStudentBirthday(rs.getDate("student_birthday"));
				return vo;
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return null; // 처리가 된 건수가 없음 : 에러
	}
	// 수정 : update
	// 삭제 : delete
	// 목록 : list
	// 조회 : select

}//
