package sec02.exam01_createthread;

import java.awt.Toolkit;

public class BeepPrintExample1 {
	//main thread �� main()�޼ҵ带 ����
	public static void main(String[] args) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();	
		for(int i=0; i<5; i++) {		
			toolkit.beep();
			try { Thread.sleep(1000); } catch(Exception e) {}
		}

		for(int i=0; i<5; i++) {
			System.out.println("��");
			try { Thread.sleep(1000); } catch(Exception e) {}
		}
	}
}
