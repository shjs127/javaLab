package sec07.exam01_constructor;

import java.io.IOException;

public class KeyboardToStringExample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte[] bytes=new byte[100];
		
		System.out.println("ют╥б: ");
		int readByteNo=System.in.read(bytes);
		System.out.println("readByteNo="+readByteNo);
		
		String str=new String(bytes,0,readByteNo-2);
		System.out.println(str);
		
	}

}
