package sec13.exam02_random;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {

		int[] selectNumber = new int[6];
		Random random = new Random(3);
		System.out.println("선택번호:");
		for (int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
			System.out.print(selectNumber[i] + " ");
		}
		System.out.println();
		// 당첨번호
		int[] win = new int[6];
		random = new Random(5);
		System.out.println("당첨번호:");
		for(int i=0; i<6; i++) {
			win[i]=random.nextInt(45)+1;
			System.out.print(win[i]);
		}
	}
}
