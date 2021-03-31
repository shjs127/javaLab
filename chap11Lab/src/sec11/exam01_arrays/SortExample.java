package sec11.exam01_arrays;

import java.util.Arrays;

public class SortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] scores= {99,97,98};
		Arrays.sort(scores);
		for(int i=0; i<scores.length; i++) {
			System.out.println("scores["+i+"]="+scores[i]);
		}
		System.out.println();
		
		String[] string= {"ȫ�浿", "�ڵ���","��μ�"};
		Arrays.sort(string);
		for (int i=0;i<string.length; i++) {
			System.out.println("string["+i+"]="+string[i]);
		}
		System.out.println();
		
		Member m1=new Member("ȫ�浿");
		Member m2=new Member("�ڵ���");
		Member m3=new Member("��μ�");
		Member[] members= {m1,m2,m3};
		Arrays.sort(members);
		for (int i=0;i<members.length; i++) {
			System.out.println("members["+i+"]="+members[i].name);
		}
		
	}

}
