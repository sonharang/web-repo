package co.yedam.board.web;


import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.serviceImpl.BoardServiceImpl;
import co.yedam.common.Command;

public class GetBoardControl implements Command {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String bno = req.getParameter("bno");

		BoardService svc = new BoardServiceImpl();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		req.setAttribute("bno", vo);

		RequestDispatcher rd = req.getRequestDispatcher("/product/productInfo.tiles");
		
		List<BoardVO> list = svc.rboardList();
		req.setAttribute("list", list);
		
		try {
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
