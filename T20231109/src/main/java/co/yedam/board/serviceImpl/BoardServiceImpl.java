package co.yedam.board.serviceImpl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.board.mapper.BoardMapper;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.common.DataSourceMybatis;


public class BoardServiceImpl implements BoardService  {
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);
	
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
	
	@Override
	public List<BoardVO> boardList() {
		return mapper.selectList();
	}
	@Override
	public BoardVO getBoard(int prodCode) {
		return mapper.select(prodCode);
	}
	@Override
	public List<BoardVO> rboardList() {
		return mapper.rselectList();
	}
}	