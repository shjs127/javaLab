package programmers;

import java.util.Arrays;

public class K¹øÂ°¼ö {
	public static void main(String[] args) {
		int[] a1 = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] com = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		int[] answer;
		answer = solution(a1, com);
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		for (int i = 0; i < commands.length; i++) {

			int[] arr1 = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(arr1);
			answer[i] = arr1[commands[i][2]-1];
		}

		return answer;
	}

}
