package test1;

import java.util.Scanner;

public class ExitGame {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] data=new int[5];
		int sum=0;
		
		for (int i=0; i<5; i++)
		{
			System.out.print("입력 : ");
			data[i]=sc.nextInt();
			sum+=data[i];
			if(sum>=100) {
				System.out.println("합 : "+sum);
				System.out.println("합이 100이상입니다.");
				break;
			}
			System.out.print("합 : "+sum);
			System.out.println();
		}
		System.out.println("프로그램 종료!");
	}

}
