package sec03.exam03_tostring;

public class SmartPhoneExample {

	public static void main(String[] args) {

		SmartPhone myPhone=new SmartPhone("����", "�ȵ���̵�");
		
		String strObj=myPhone.toString();
		System.out.println(strObj);
		
		System.out.println(myPhone);
		
		String str1=new String("ȫ�浿");
		System.out.println(str1.toString());
		
		
	}

}
