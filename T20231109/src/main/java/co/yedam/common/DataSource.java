package co.yedam.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	//싱글톤 클래스 : 인스턴스 하나만 생성 (DAO 객체)
	//인스턴스 스택영역에 등록
	private static DataSource dataSource = new DataSource();
	//자신이 자신의 생성자
	private DataSource() {}
	
	private static String driver = "oracle.jdbc.driver.OracleDriver";
	private static String url = "jdbc:oracle:thin:@192.168.0.37:1521:xe"; //@호스트명 포트명 SID
	private static String user = "hr";
	private static String password = "1234";
	
	private static Connection conn;
	//외부에서는 자신의 인스턴스 사용하게 게터,세터
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,user,password);
			//System.out.println("DB연결성공");
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
}//
