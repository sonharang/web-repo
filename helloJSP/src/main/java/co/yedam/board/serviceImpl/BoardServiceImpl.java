package co.yedam.board.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.board.mapper.BoardMapper;
import co.yedam.board.service.BoardService;
import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.common.DataSourceMybatis;

public class BoardServiceImpl implements BoardService {
	BoardDAO dao = new BoardDAO();
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true); // 자동커밋
	BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);

	@Override
	public List<BoardVO> boardList() {
		// return dao.boardList();
		return mapper.selectList();
	}

	@Override
	public BoardVO getBoard(int boardNo) {
//		dao.updateCnt(boardNo);
//		return dao.select(boardNo);
		mapper.updateCnt(boardNo);
		return mapper.select(boardNo);
	}

	@Override
	public boolean addBoard(BoardVO vo) {
		// return dao.insert(vo) == 1;
		return (mapper.insert(vo) == 1);
	}

	@Override
	public boolean editBoard(BoardVO vo) {
		// return dao.updateBoard(vo) == 1 ;
		return (mapper.updateBoard(vo) == 1);
	}

	@Override
	public boolean removeBoard(int boardNo) {
		// return dao.delete(boardNo) == 1 ;
		return (mapper.delete(boardNo) == 1);
	}

	@Override
	public MemberVO loginCheck(String id, String pw) {
		// return dao.getUser(id, pw);
		return mapper.getUser(id, pw);
	}

	@Override
	public List<MemberVO> memberList() {
		// return dao.memberlist();
		return mapper.memberList();
	}

}//
