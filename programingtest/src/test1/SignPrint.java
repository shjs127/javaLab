package test1;

import java.util.Scanner;

public class SignPrint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("���ڸ� �Է��ϼ��� : ");
		int num = sc.nextInt();

		String result = (num > 0) ? "���" : ((num == 0) ? "0" : "����");
		System.out.println(result);

	}

}
