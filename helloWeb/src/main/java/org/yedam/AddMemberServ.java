package org.yedam;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.yedam.service.MemberService;
import org.yedam.service.MemberVO;
import org.yedam.service.serviceImpl.MemberServiceImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AddMemberServ
 */
@WebServlet("/AddMemberServ.html")
public class AddMemberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMemberServ() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ?mid=M009&pass=9999&name=Kim&phone=010-9876-0987
		String mid = request.getParameter("mid");
		//response.getWriter().append("id: ").append(mid);
		String pass = request.getParameter("pass");
		//response.getWriter().append("\npassword: ").append(pass);
		String name = request.getParameter("name");
		//response.getWriter().append("\nname: ").append(name);
		String phone = request.getParameter("phone");
		//response.getWriter().append("\nphone: ").append(phone);

		// 멤버 인스턴스 선언
		MemberVO vo = new MemberVO(mid, pass, name, phone);
		
		// db에 입력(insert)
		MemberService svc = new MemberServiceImpl();
		PrintWriter out = response.getWriter();
		Gson gson = new GsonBuilder().create();
		//String json = gson.toJson(vo);
		//out.print(vo);
		
		//map
		Map<String, Object>map = new HashMap<>();
		
		if (svc.addMember(vo)) {
			map.put("retCode", "OK");
			map.put("vo", vo);
			// JSON 문자열
			// {"retCode": "OK"}
			//out.print("{\"retCode\": \"OK\"}");
			//out.print(json);
		} else {
			// {"retCode": "NG"}
			//out.print("{\"retCode\": \"NG\"}");
			//out.print(json);
			map.put("retCode", "NG");
			map.put("vo", vo.getMid());
		}
		String json = gson.toJson(map);
		out.print(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
