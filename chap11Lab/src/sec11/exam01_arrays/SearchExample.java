package sec11.exam01_arrays;

import java.util.Arrays;

public class SearchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�⺻Ÿ�԰� �˻�
		int[] scores= {99,97,98};
		Arrays.sort(scores);
		int index=Arrays.binarySearch(scores, 97);
		System.out.println("ã�� �ε���:"+index);
		
		//���ڿ� �˻�
		String[] name= {"ȫ�浿","�ڵ���","��μ�"};
		Arrays.sort(name);
		int index1=Arrays.binarySearch(name, "ȫ�浿");
		System.out.println("ã�� �ε���:"+index1);
		
	}

}
