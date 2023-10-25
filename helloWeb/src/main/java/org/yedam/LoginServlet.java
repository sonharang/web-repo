package org.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, Integer> map = new HashMap<>();
		map.put("홍길동", 90);
		map.put("김길동", 95);
		map.put("박길동", 80);
		Set<String> keyset = map.keySet();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setCharacterEncoding("UTF-8");
//		response.setCharacterEncoding(getServletInfo());
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter(); // 출력스트림

		out.println("톰캣을 재시작 해야지 바뀐 내용이 적용 됩니다.");
		out.println("<br>");
		out.println("<h3>학생이름과 점수</h3>");
//		out.println("<table border='1'><thead><tr>");
//		out.println("<th>학생이름</th><th>점수</th></tr></thead>");
		String str = "<table border='1'><thead><tr>";
		str += "<th>학생이름</th><th>점수</th></tr></thead>";
		str += "<tbody>";
		for (String item : keyset) {
			str += "<tr><td>" + item + "</td><td>" + map.get(item) + "</td></tr>";
		}
		str += "</tbody></table>";
		out.print(str);

		out.println("<br>");
		out.println("<a href='index.html'>첫페이지</a>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
