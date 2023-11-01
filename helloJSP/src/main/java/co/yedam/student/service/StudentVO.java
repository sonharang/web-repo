package co.yedam.student.service;

import java.util.Date;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class StudentVO {
	private String studentId;
	private String studentName;
	private String studentPassword;
	private String studentDept;
	private Date studentBirthday;
	
}
