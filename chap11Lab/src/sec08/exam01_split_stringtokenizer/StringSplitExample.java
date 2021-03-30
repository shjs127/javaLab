package sec08.exam01_split_stringtokenizer;

public class StringSplitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="홍길동@이수홍,반연수&김자바_최면호";
		String[] names=text.split("@|&|,|_");
		
		for(String name:names) {
			System.out.println(name);
		}
	} 

}
