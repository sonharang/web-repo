package co.yedam.reply.serviceImpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.yedam.common.DataSourceMybatis;
import co.yedam.reply.mapper.ReplyMapper;
import co.yedam.reply.service.ReplyService;
import co.yedam.reply.service.ReplyVO;

public class ReplyServiceImpl implements ReplyService{
	SqlSession sqlSession = 
			DataSourceMybatis.getInstance().openSession(true); // 자동커밋
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	@Override
	public boolean addReply(ReplyVO vo) {
		return false;
	}
	@Override
	public boolean editReply(ReplyVO vo) {
		return false;
	}
	@Override
	public boolean removeReply(ReplyVO vo) {
		return false;
	}
	@Override
	public List<ReplyVO> replyList() {
		return null;
	}
	@Override
	public ReplyVO getReply(int boardNo) {
		return null;
	}
}
