package co.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.web.AddBoardControl;
import co.yedam.board.web.BoardFormControl;
import co.yedam.board.web.BoardListControl;
import co.yedam.board.web.GetBoardControl;

public class FrontController extends HttpServlet {

	// init -> service
	Map<String, Command> map = new HashMap<>();

	@Override
	public void init(ServletConfig config) throws ServletException {
		// map.put("/FirstServlet.do", new FirstControl());
		// map.put("/second.do", new SecondControl());
		map.put("/boardList.do", new BoardListControl()); // 목록
		map.put("/getBoard.do", new GetBoardControl()); // 조회
		map.put("/boardForm.do", new BoardFormControl()); // 등록
		map.put("/addBoard.do", new AddBoardControl()); // 추가 처리
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("FrontController");
		String uri = req.getRequestURI(); // http://localhost8080/helloJSP/boardList.do
		String context = req.getServletContext().getContextPath(); // helloJSP
		String page = uri.substring(context.length());
		System.out.println(page); // 키값, 컨트롤기능 실행

		Command controller = map.get(page);
		// System.out.println(control);
		controller.execute(req, resp);

//		if(page.equals("/second.do")) {
//			
//		}else if(page.equals("/FirstServlet.do")) {
//			
//		}
	}
	
}
