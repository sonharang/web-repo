package co.yedam.student.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

@WebServlet("/getStudent.do")
public class GetStudentServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		// 학생정보 json으로 전송
		String sid = req.getParameter("sid");
		StudentService svc = new StudentServiceImpl();
		if (svc.getStudent(sid) != null) {
			// resp.getWriter().print("{\"retCode\" : \"OK\"}");
			// resp.getWriter().print(svc.getStudent(sid));
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd") // 포맷
					.create();
			String json = gson.toJson(svc.getStudent(sid));
			PrintWriter out = resp.getWriter();
			out.println(json);
		} else {
			resp.getWriter().print("{\"retCode\" : \"NG\"}");

		}
	}

}
