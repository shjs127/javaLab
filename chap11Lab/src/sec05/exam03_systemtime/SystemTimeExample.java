package sec05.exam03_systemtime;

public class SystemTimeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//정적 메소드는 객체  생성없이 클래스 이름.메소드로 직접 메소드 호출
		long time1=System.nanoTime();
		
		int sum=0;
		for (int i=1; i<=1000000; i++) {
			sum +=i;
		}
	
	long time2=System.nanoTime();
	
	System.out.println("1~1000000까지의 합"+sum);
	System.out.println("계산에 "+(time2-time1)+"나노초가 소요되었습니다.");
	
	}
	
	

}
