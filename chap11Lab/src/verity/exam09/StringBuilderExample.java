package verity.exam09;

public class StringBuilderExample {
	public static void main(String[] args) {
		String str = "";
		for (int i = 1; i <= 100; i++) {
			str += i;
		}
		System.out.println(str);
		// 작성 위치
		StringBuilder str2=new StringBuilder();
		
		for(int i=1;i<=100;i++) {
			str2.append(i);
			
		}
		
		System.out.println(str2.toString());


		
	}
}



// 실행 결과
// 12345678910111213141516171819202122232....100
// 12345678910111213141516171819202122232....100
