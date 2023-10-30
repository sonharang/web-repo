package org.yedam.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class bookVO {
	private String id;
	private String name;
	private String writer;
	private String publish;
	private String price;
	public String toString() {
	if(id != null) {
		System.out.print("\t" + id + " : ");
		System.out.print(name + " : ");
		System.out.print(writer + " : ");
		System.out.print(publish + " : ");
		System.out.println(price);
		}else {
			System.out.println("\t존재하지 않는 도서입니다.");
		}
		return "도서코드: " + id + " 도서명: " + name + " 저자: " + writer + " 출판사: " + publish + " 가격" + price + "\n";
	}	
}	