package sec06.exam03_join;

public class JoinExample {
	//메인 스레드가 실행
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		//작업 스레드가 실행
		sumThread.start();
		/*
		try {
			//main 스레드가 작업 드레스가 완료될때까지 일시 대기상태로 있는다
			sumThread.join();
		} catch (InterruptedException e) {
		}
		*/
		System.out.println("1~100 합: " + sumThread.getSum());
	}
}

