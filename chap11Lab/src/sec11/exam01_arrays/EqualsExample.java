package sec11.exam01_arrays;

import java.util.Arrays;

public class EqualsExample {

	public static void main(String[] args) {

		int[][] original= {{1,2},{3,4}};
		
		//�A�� ����
		int[][] cloned1=Arrays.copyOf(original,original.length);
		System.out.println("�迭���� ��"+original.equals(cloned1));
		System.out.println("1�� �迭 �׸� �� ��"+Arrays.equals(original, cloned1));
		System.out.println("��ø�迭 �׸� ��"+ Arrays.deepEquals(original, cloned1));
		System.out.println(cloned1);

	}

}
