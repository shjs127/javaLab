package test1;

import java.util.Scanner;

public class ExitGame {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] data=new int[5];
		int sum=0;
		
		for (int i=0; i<5; i++)
		{
			System.out.print("�Է� : ");
			data[i]=sc.nextInt();
			sum+=data[i];
			if(sum>=100) {
				System.out.println("�� : "+sum);
				System.out.println("���� 100�̻��Դϴ�.");
				break;
			}
			System.out.print("�� : "+sum);
			System.out.println();
		}
		System.out.println("���α׷� ����!");
	}

}
