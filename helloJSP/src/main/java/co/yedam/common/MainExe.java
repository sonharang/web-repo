package co.yedam.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainExe {

	public static void main(String[] args) {
		DataSource ds = DataSource.getInstance();
		Connection conn = ds.getConnection();
		try {
			PreparedStatement psmt = conn.prepareCall("select * from student");
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println("===============");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
