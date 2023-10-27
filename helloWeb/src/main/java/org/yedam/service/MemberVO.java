package org.yedam.service;

public class MemberVO {
	private String mid;
	private String pass;
	private String name;
	private String phone;
	
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
//		if(mid != null) {
//			System.out.print("\t" + mid + " : ");
//			System.out.print(pass + " : ");
//			System.out.print(name + " : ");
//			System.out.println(phone);
//			}else {
//				System.out.println("\t존재하지 않는 회원입니다.");
//			}return null;
		return "아이디: " + mid + " 비밀번호: " + pass + " 이름: " + name + " 전화번호: " + phone + "\n";
	}
}
