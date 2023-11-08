package co.yedam.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardDAO;
import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.service.ReplyVO;
import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;
import co.yedam.student.serviceImpl.StudentServiceImpl;

public class MainExe {
//	public static void main(String[] args) {
//		DataSource ds = DataSource.getInstance();
//		Connection conn = ds.getConnection();
//		try {
//			PreparedStatement psmt = conn.prepareCall("select * from student");
//			ResultSet rs = psmt.executeQuery();
//			while (rs.next()) {
//				System.out.println(rs.getString(1));
//				System.out.println(rs.getString(2));
//				System.out.println(rs.getString(3));
//				System.out.println("===============");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}

	public static void main(String[] args) {
//		BoardDAO dao = new BoardDAO();
//		BoardVO vo = new BoardVO();
//		System.out.println(dao.boardList());
		
		
		
		
		
		//StudentService svc = new StudentServiceImpl();
		
		
		//추가
		// 학생아이디, 비밀번호, 이름, 학과, 생일
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//StudentVO vo = new StudentVO();
//		vo.setStudentId("newbie");
//		vo.setStudentName("신입생");
//		vo.setStudentPassword("1234");
//		vo.setStudentDept("영문학과");
//		try {
//			vo.setStudentBirthday(sdf.parse("2001-01-01"));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		if(svc.addStudent(vo)) {
//			System.out.println("정상등록.");
//		}else {
//			System.out.println("에러발생.");
//		}
		//수정
//		vo.setStudentId("newbie");
//		vo.setStudentName("신입생생생");
//		vo.setStudentPassword("123456789");
//		vo.setStudentDept("한국영문일본학과");
//		if(svc.editStudent(vo)) {
//			System.out.println("정상수정.");
//		}else {
//			System.out.println("에러발생.");
//		}
		//삭제
//		if(svc.removeStudent("newbie")) {
//			System.out.println("정상삭제.");
//		}else {
//			System.out.println("에러발생.");
//		}
//		//목록
//		if(svc.listStudent()) {
//			System.out.println("정상등록.");
//		}else {
//			System.out.println("에러발생.");
//		}
//		//조회
	//	System.out.println(svc.getStudent("kim"));
		
		//System.out.println("=======================================================================================================================");
		//svc.listStudent().forEach(student -> System.out.println(student));//

		
		SqlSession session = 
				DataSourceMybatis.getInstance().openSession(true);
		ReplyMapper mapper = session.getMapper(ReplyMapper.class);
		//System.out.println(mapper.replyList());
		//System.out.println(mapper.deleteReply(4));
		//mapper.replyList(2,2).forEach(rep->System.out.print(rep));
		List<Map<String, Object>> map = mapper.getReplyCountByWriter();
		System.out.println(map);
	}
	

}//
