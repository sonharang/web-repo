package co.yedam.reply.service;

import java.util.List;

public interface ReplyService {
	public boolean addReply(ReplyVO vo);
	public boolean editReply(ReplyVO vo);
	public boolean removeReply(int  replyNo);
	public List<ReplyVO> replyList(int boardNo);
	public ReplyVO getReply(int replyNo);
	
}
