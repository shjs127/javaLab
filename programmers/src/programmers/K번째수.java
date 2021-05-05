package programmers;

import java.util.Arrays;

public class K¹øÂ°¼ö {
	public static void main(String[] args) {
			int[] a1= {1,5,2,6,3,7,4};
			int[][] com= {{2,5,3},{4,4,1},{1,7,3}};
			
			int[] answer;
			answer=solution(a1,com);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = {};
		int[] arr1=Arrays.copyOfRange(array, commands[0][0], commands[0][1]);
		answer[0]=Arrays.binarySearch(arr1,commands[0][2]);
		
		
		return answer;
	}

}
