package org.yedam.service;

import java.util.List;

public interface MemberService {
	//회원목록 : memberList()
	public List<MemberVO> memberList();
	public boolean addMember(MemberVO vo);
	public boolean modMember(MemberVO vo);
	public boolean delMember(MemberVO vo);
}
