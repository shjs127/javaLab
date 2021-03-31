package verify.exam08;

import java.util.StringTokenizer;

public class SplitExample {

	public static void main(String[] args) {
		String str = "���̵�,�̸�,�н�����";
		// �ۼ� ��ġ
		// #1: split() �޼ҵ� �̿�
		String[] names=str.split(",");
		
		for(String name:names) 
			System.out.println(name);
		System.out.println();
		// #2: StringTokenizer �̿�
		StringTokenizer st=new StringTokenizer(str,",");
		int count=st.countTokens();
		for (int i=0;i<count;i++) {
			String token=st.nextToken();
			System.out.println(token);
			System.out.println();
		}
	}

}
