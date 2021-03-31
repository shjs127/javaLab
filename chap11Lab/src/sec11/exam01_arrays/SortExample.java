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
		
		String[] string= {"È«±æµ¿", "¹Úµ¿¼ö","±è¹Î¼ö"};
		Arrays.sort(string);
		for (int i=0;i<string.length; i++) {
			System.out.println("string["+i+"]="+string[i]);
		}
		System.out.println();
		
		Member m1=new Member("È«±æµ¿");
		Member m2=new Member("¹Úµ¿¼ö");
		Member m3=new Member("±è¹Î¼ö");
		Member[] members= {m1,m2,m3};
		Arrays.sort(members);
		for (int i=0;i<members.length; i++) {
			System.out.println("members["+i+"]="+members[i].name);
		}
		
	}

}
