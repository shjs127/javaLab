package sec07.exam02_method;

public class StringLengthExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints=new int[3];
		System.out.println(ints.length);   //length 필드값을 구한다.
		
		String ssn="7890456";
		int length=ssn.length();  //String 은 length()메소드를 호출하여 길이를 구한다
		System.out.println(length);
		if(length==7) {
			System.out.println("주민번호 자리수가 맞습니다.");
		}else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
	}

}
