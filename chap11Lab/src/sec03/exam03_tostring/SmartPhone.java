package sec03.exam03_tostring;

public class SmartPhone {
	
	//필드
	private String company;
	private String os;
	//생성자
	public SmartPhone(String company, String os) {
		this.company=company;
		this.os=os;
	}
	//메소드

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return company+","+os;
	}
	
	
	

}
