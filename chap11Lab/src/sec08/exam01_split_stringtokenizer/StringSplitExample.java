package sec08.exam01_split_stringtokenizer;

public class StringSplitExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text="ȫ�浿@�̼�ȫ,�ݿ���&���ڹ�_�ָ�ȣ";
		String[] names=text.split("@|&|,|_");
		
		for(String name:names) {
			System.out.println(name);
		}
	} 

}
