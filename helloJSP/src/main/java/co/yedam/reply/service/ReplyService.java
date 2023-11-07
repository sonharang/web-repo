package co.yedam.reply.service;

import java.util.List;

public interface ReplyService {
	public boolean addReply(ReplyVO vo);
	public boolean editReply(ReplyVO vo);
	public boolean removeReply(ReplyVO vo);
	public List<ReplyVO> replyList();
	public ReplyVO getReply(int boardNo);
	
}
