package verify.exam08;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		// 작성 위치
		// #1: split() 메소드 이용
		String[] names=str.split(",");
		
		for(String name:names) 
			System.out.println(name);
		System.out.println();
		// #2: StringTokenizer 이용
		StringTokenizer st=new StringTokenizer(str,",");
		int count=st.countTokens();
		for (int i=0;i<count;i++) {
			String token=st.nextToken();
			System.out.println(token);
			System.out.println();
		}
	}

}
