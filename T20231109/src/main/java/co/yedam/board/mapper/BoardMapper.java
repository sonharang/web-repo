package co.yedam.board.mapper;

import java.util.List;

import co.yedam.board.service.BoardVO;

public interface BoardMapper {
	public List<BoardVO> selectList();
	public BoardVO select(int prodCode);

	public List<BoardVO> rselectList();
}
