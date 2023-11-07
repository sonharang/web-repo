package co.yedam.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import co.yedam.board.service.BoardVO;
import co.yedam.board.service.MemberVO;
import co.yedam.reply.service.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> selectList();
	
}//
