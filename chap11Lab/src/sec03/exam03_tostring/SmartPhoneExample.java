package sec03.exam03_tostring;

public class SmartPhoneExample {

	public static void main(String[] args) {

		SmartPhone myPhone=new SmartPhone("구글", "안드로이드");
		
		String strObj=myPhone.toString();
		System.out.println(strObj);
		
		System.out.println(myPhone);
		
		String str1=new String("홍길동");
		System.out.println(str1.toString());
		
		
	}

}
