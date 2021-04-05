package test1;

import java.util.Scanner;

public class SignPrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();

		String result = (num > 0) ? "양수" : ((num == 0) ? "0" : "음수");
		System.out.println(result);

	}

}
