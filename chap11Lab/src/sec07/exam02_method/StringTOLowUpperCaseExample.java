package sec07.exam02_method;

public class StringTOLowUpperCaseExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String str1="java Programming";
		String str2="JAVA Programming";
		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));
		
		String lowerStr1=str1.toLowerCase();
		String lowerStr2=str2.toLowerCase();
		System.out.println(lowerStr1.equals(lowerStr2));
		
		
	}

}
