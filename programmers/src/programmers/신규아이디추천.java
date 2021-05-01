package programmers;

public class 신규아이디추천 {
	public static void main(String[] args) {
		String A = "...!@BaT#*..y.abc_45def_ghijklm";

		String B = "...!@#$as-dfjklBA12 3-SE*&ASDF.D.";

		String C = "+3+";

		String answer = Solution(A);
		System.out.println(answer);

		answer = Solution(B);
		System.out.println(answer);

		answer = Solution(C);
		System.out.println(answer);

	}

	private static String Solution(String new_id) {
		String answer = new_id;
		answer = answer.toLowerCase();
		answer = answer.replaceAll("[^-_.a-z0-9]","");
		while (answer.contains("..")) {
			answer = answer.replace("..", ".");
		}
		if (answer.charAt(0) == '.') {
			answer = answer.substring(1, answer.length() );
		}
		 if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
	            answer = answer.substring(0, answer.length()-1);
	        }
		if (answer.contains("\s"))
			answer = answer.replace("\s", "a");
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);
			if (answer.charAt(answer.length() - 1) == '.') {
				answer = answer.substring(0, answer.length() - 1);
			}
		}
		  if(answer.length() <= 2){
	            Character c = answer.charAt(answer.length()-1);

	            while(answer.length() != 3){
	                answer += Character.toString(c);
	            }
	        }
		return answer;

	}
}
