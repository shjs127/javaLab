package sec03.exam03_tostring;

public class SmartPhone {
	
	//�ʵ�
	private String company;
	private String os;
	//������
	public SmartPhone(String company, String os) {
		this.company=company;
		this.os=os;
	}
	//�޼ҵ�

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return company+","+os;
	}
	
	
	

}
