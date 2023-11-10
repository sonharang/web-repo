package co.yedam.board.service;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
public class BoardVO {
	private int prodCode;
	private String prodName;
	private String prodDesc;
	private int price;
	private int offPrice;
	private int likeIt;
	private String prodImage;
	
}
