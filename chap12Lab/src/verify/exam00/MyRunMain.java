package verify.exam00;

public class MyRunMain {

	public static void main(String[] args) {
		MyRun mr1 = new MyRun();
		Thread t1 = new Thread(mr1);
		Thread t2 = new MyThread();
		t1.start();
		t2.start();
		for (int i = 0; i < 500; i++) {
		System.out.print("M");
		}
	}

}
