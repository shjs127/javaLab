package verify.exam00;

import java.io.InputStream;
import java.util.Scanner;

public class JuminCheck01 {

	// �ֹι�ȣ Ÿ�缺 �˻��ϴ� �޼ҵ�
	public boolean juminCheck(String jumin) {
		// jumin = "8010101234567";
		int total = 0;
		int total2;

		int[] mul = { 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5 };

		for (int i=0; i<12; i++) {
			total += Integer.parseInt(jumin.substring(i, i + 1)) * mul[i];
		}

		total %= 11; // total = total % 11;
		total2 = 11 - total;
		if (total2 > 9)
			total2 = total2 % 10;

		if (total2 != Integer.parseInt(jumin.substring(12, 13))) {
			return false; // üũ�� ��ȣ�� ��ġ���� ������
		} else {
			return true;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JuminCheck01 jc = new JuminCheck01();

		InputStream is = System.in;
		Scanner sc = new Scanner(is);

		System.out.println("�ֹι�ȣ ���ڸ��� �Է� �ϼ���?");
		String jumin1 = sc.next(); // 800101
		System.out.println("�ֹι�ȣ ���ڸ��� �Է� �ϼ���?");
		String jumin2 = sc.next(); // 1234567

		if (jumin1.length() != 6) {
			System.out.println("�ֹι�ȣ ���ڸ��� 6�ڸ� �Է�");
		} else if (jumin2.length() != 7) {
			System.out.println("�ֹι�ȣ ���ڸ��� 7�ڸ� �Է�");
		} else if (!jc.juminCheck(jumin1 + jumin2)) {
			System.out.println("�߸��� �ֹι�ȣ �Դϴ�.");
		} else {
			System.out.println("�ùٸ� �ֹι�ȣ �Դϴ�");
		}

	}

}