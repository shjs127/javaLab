package sec03.exam02_console;

import java.io.Console;

public class ConsoleExample {
	public static void main(String[] args) {
		Console console = System.console();
		
		System.out.print("���̵�: ");
		String id = console.readLine();
		String strid=new String(id);
		
		System.out.print("�н�����: ");
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass);
		
		System.out.println("---------------------");
		System.out.println(strid);
		System.out.println(strPassword);
	}
}
