package org.yedam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.yedam.common.DataSource;
import org.yedam.service.bookVO;


public class BookServiceImpl implements BookService {
	DataSource dataSource = DataSource.getInstance();
	Connection conn = dataSource.getConnection();
	PreparedStatement psmt;
	ResultSet rs;
	
	@Override
public List<bookVO> bookList() {
		List<bookVO> books = new ArrayList<>();
		bookVO vo;
		String sql = "SELECT * FROM testbook";
		try {
			conn = dataSource.getConnection();
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				vo = new bookVO();
				vo.setId(rs.getString("BOOK_CODE"));
				vo.setName(rs.getString("BOOK_TITLE"));
				vo.setWriter(rs.getString("BOOK_AUTHOR"));
				vo.setPublish(rs.getString("BOOK_PRESS"));
				vo.setPrice(rs.getString("BOOK_PRICE"));
				books.add(vo);
			}
				rs.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return books;
	}

	private void close() {
		try {
			if(psmt != null)psmt.close();
			if(conn != null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
