package co.yedam.student.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.yedam.student.service.StudentService;
import co.yedam.student.service.StudentVO;
import co.yedam.student.serviceImpl.StudentServiceImpl;

@WebServlet("/editStudent.do")
public class ModStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		// 수정 -> 바뀐정보
		StudentVO vo = new StudentVO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		vo.setStudentName(req.getParameter("name"));
		vo.setStudentPassword(req.getParameter("password"));
		try {
			vo.setStudentBirthday(sdf.parse(req.getParameter("birth")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		vo.setStudentId(req.getParameter("id"));
		// 반환할 값: map으로 생성
		Map<String, Object> map = new HashMap<>();
		StudentService svc = new StudentServiceImpl();
		if (svc.editStudent(vo)) {
			map.put("retCode", "OK");
			map.put("VO", vo);
		} else {
			map.put("retCode", "NG");
			map.put("VO", vo);
		}
		svc.addStudent(vo);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd") // 포맷
				.create();

		String json = gson.toJson(map);
		PrintWriter out = resp.getWriter();
		out.println(json);
	}
}
