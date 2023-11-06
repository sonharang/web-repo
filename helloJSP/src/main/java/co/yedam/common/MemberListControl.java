package co.yedam.common;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;

public class MemberListControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 서블릿,jsp : 서블릿(컨트롤 : 데이터처리) -> jsp(뷰)
				BoardService svc = new BoardServiceImpl();
				List<MemberVO> list = svc.memberList();
				
				req.setAttribute("list", list); //이름, 주소값
				
				// 페이지 요청(boardList.do) -> 요청 재지정(board/boardList.jsp)
				RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/board/memberList.jsp");// .forward(req,resp);
				try {
					rd.forward(req, resp); //이동할 페이지로 포워딩 ("board/boardList.jsp");
				} catch (Exception e) {
					e.printStackTrace();
				} // catch
	}

}
