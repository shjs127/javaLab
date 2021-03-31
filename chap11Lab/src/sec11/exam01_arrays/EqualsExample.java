package sec11.exam01_arrays;

import java.util.Arrays;

public class EqualsExample {

	public static void main(String[] args) {

		int[][] original= {{1,2},{3,4}};
		
		//얖은 복사
		int[][] cloned1=Arrays.copyOf(original,original.length);
		System.out.println("배열번지 비교"+original.equals(cloned1));
		System.out.println("1차 배열 항목 값 비교"+Arrays.equals(original, cloned1));
		System.out.println("중첩배열 항목값 비교"+ Arrays.deepEquals(original, cloned1));
		System.out.println(cloned1);

	}

}
