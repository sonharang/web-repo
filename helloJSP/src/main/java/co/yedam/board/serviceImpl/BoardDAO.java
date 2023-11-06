package co.yedam.board.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import co.yedam.board.service.BoardVO;
import co.yedam.common.DataSource;

public class BoardDAO {
	// 목록, 단건조회, 등록, 수정, 삭제

	// connection 객체
	DataSource ds = DataSource.getInstance();
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	String sql;

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

	public int insert(BoardVO vo) {
		String sql = "INSERT INTO BOARD(BOARD_NO, TITLE, CONTENT, WRITER, IMAGE) VALUES(SEQ_BOARD.NEXTVAL,?, ?, ?, ?)";
		conn = ds.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getImage());
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

	public int updateBoard(BoardVO vo) {
		String sql = "UPDATE BOARD SET TITLE = ?,WRITER = ? , "
				+ "CONTENT = ?, IMAGE = NVL(?, IMAGE),LAST_UPDATE = SYSDATE WHERE BOARD_NO = ?";
		conn = ds.getConnection();
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getWriter());
			psmt.setString(3, vo.getContent());
			psmt.setString(4, vo.getImage());
			psmt.setInt(5, vo.getBoardNo());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리가 된 건수가 없음 : 에러
	}

	public int delete(int boardNo) {
		String sql = "DELETE FROM BOARD WHERE BOARD_NO = ?";
		conn = ds.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리가 된 건수가 없음 : 에러
	}

	public List<BoardVO> boardList() {
		List<BoardVO> boards = new ArrayList<>();
		BoardVO vo;
		String sql = "SELECT * FROM BOARD ORDER BY BOARD_NO";
		conn = ds.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("BOARD_NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setWriteDate(rs.getDate("WRITE_DATE"));
				vo.setViewCnt(rs.getInt("VIEW_CNT"));
				vo.setImage(rs.getString("IMAGE"));
				vo.setLastUpdate(rs.getDate("LAST_UPDATE"));
				boards.add(vo);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return boards; // 처리가 된 건수가 없음 : 에러
	}

	public BoardVO select(int boardNo) {
		String sql = "SELECT * FROM BOARD WHERE BOARD_NO=?";
		conn = ds.getConnection();
		BoardVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				vo = new BoardVO();
				vo.setBoardNo(rs.getInt("BOARD_NO"));
				vo.setTitle(rs.getString("TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setWriter(rs.getString("WRITER"));
				vo.setWriteDate(rs.getDate("WRITE_DATE"));
				vo.setViewCnt(rs.getInt("VIEW_CNT"));
				vo.setImage(rs.getString("IMAGE"));
				vo.setLastUpdate(rs.getDate("LAST_UPDATE"));
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
	// method 구현

	// 조회수 증가
	public int updateCnt(int boardNo) {
		String sql = "UPDATE BOARD SET VIEW_CNT=VIEW_CNT+1 WHERE BOARD_NO =?";
		conn = ds.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, boardNo);

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return 0; // 처리가 된 건수가 없음 : 에러
	}

	// 아이디, 비밀번호 => 조회값 : boolean
	public boolean getUser(String id, String pw) {
		String sql = "SELECT * FROM MEMBER2 WHERE MID = ? AND PASS = ?";
		conn = ds.getConnection();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);

			rs = psmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return false; // 처리가 된 건수가 없음 : 에러
	}
}// end of dao
