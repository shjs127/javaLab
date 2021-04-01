package sec11.exam01_arrays;

import java.util.Arrays;

public class SearchExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//기본타입값 검색
		int[] scores= {99,97,98};
		Arrays.sort(scores);
		int index=Arrays.binarySearch(scores, 97);
		System.out.println("찾는 인덱스:"+index);
		
		//문자열 검색
		String[] name= {"홍길동","박동수","김민수"};
		Arrays.sort(name);
		int index1=Arrays.binarySearch(name, "홍길동");
		System.out.println("찾는 인덱스:"+index1);
		
	}

}
