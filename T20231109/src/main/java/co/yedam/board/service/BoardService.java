package co.yedam.board.service;

import java.util.List;

public interface BoardService {
	public List<BoardVO> boardList();
	public BoardVO getBoard(int prodCode);
	
	public List<BoardVO> rboardList();
}
