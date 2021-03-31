package sec10_exam01_pattem_match;

import java.util.regex.Pattern;

public class PatternExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String regExp="(02|010)-\\d{3,4}-\\{4}";
		String data="010-123-4567";
		boolean result =Pattern.matches(regExp,data);
		if(result) {
			System.out.println("정구식의 결과가 같다.");
			
		}else {
			System.out.println("결과가 다르다");
		}
		
		regExp="\\w+@\\w+\\.\\w+(\\.\\w+)?";
		data="angel@namver.com";
		result=Pattern.matches(regExp, data);
		result =Pattern.matches(regExp,data);
		if(result) {
			System.out.println("정구식의 결과가 같다.");
			
		}else {
			System.out.println("결과가 다르다");
		}
		
		
		
	}

}
