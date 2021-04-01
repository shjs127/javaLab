package verify.exam00;

public class MyRun implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 500; i++)
			System.out.print("S");
	}
}