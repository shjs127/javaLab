package sec07.exam02_method;

public class StringLengthExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ints=new int[3];
		System.out.println(ints.length);   //length �ʵ尪�� ���Ѵ�.
		
		String ssn="7890456";
		int length=ssn.length();  //String �� length()�޼ҵ带 ȣ���Ͽ� ���̸� ���Ѵ�
		System.out.println(length);
		if(length==7) {
			System.out.println("�ֹι�ȣ �ڸ����� �½��ϴ�.");
		}else {
			System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�.");
		}
	}

}
