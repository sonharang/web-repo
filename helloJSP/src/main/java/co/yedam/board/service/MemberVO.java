package co.yedam.board.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MemberVO {
	private String mid;
	private String pass;
	private String name;
	private String phone;
	private String responsibility;
	
}
