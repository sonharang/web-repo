package co.yedam.common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.MemberVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;

public class LoginControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String pw = req.getParameter("pass");

		BoardService svc = new BoardServiceImpl();
		MemberVO vo = svc.loginCheck(id, pw);
		HttpSession session = req.getSession();
		session.setAttribute("logId", id);
		session.setAttribute("responsibility",vo.getResponsibility() );
		if (svc.loginCheck(id, pw) != null) {
			// session : 서버 - 클라이언트 , 세션에서 값저장하고 있음
			try {
				resp.sendRedirect("boardList.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				resp.sendRedirect("loginForm.do");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
