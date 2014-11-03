package bean;

public class StudentCard {
	
	private int id;
	
	private String cardNo;
	
	
	//ÉèÖÃ¹ØÏµ
	private Student student;
	
	 
	
	
	
	
	
	public Student getStudent() {
		return student;
	}





	public void setStudent(Student student) {
		this.student = student;
	}





	public StudentCard() {
	}
	
	
	
	

	public StudentCard(String cardNo) {
		super();
		this.cardNo = cardNo;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardNo() {
		return cardNo;
	}
	

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	
	
	
	

}
