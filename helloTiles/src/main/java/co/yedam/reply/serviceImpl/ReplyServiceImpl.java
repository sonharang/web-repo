package co.yedam.reply.serviceImpl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSourceMybatis;
import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService {
	
	SqlSession sqlSession = DataSourceMybatis.getInstance().openSession(true);
	
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);

	@Override
	public boolean addReply(ReplyVO vo) {
		return (mapper.insertReply(vo) == 1);
	}

	@Override
	public boolean editReply(ReplyVO vo) {
		return (mapper.updateReply(vo) == 1);
	}

	@Override
	public boolean removeReply(int replyNo) {
		return (mapper.deleteReply(replyNo) == 1);
	}

	@Override
	public List<ReplyVO> replyList(int boardNo, int page) {
		return mapper.selectList(boardNo, page);
	}

	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}
	
	@Override
	public int getTotalCnt(int boardNo) {
		return mapper.getTotalCnt(boardNo);
	}
	
	@Override
	public List<Map<String, Object>> getReplyCntByMember() {
		return mapper.getReplyCntByMember();
	}

}
