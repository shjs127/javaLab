package sec06.exam03_join;

public class JoinExample {
	//���� �����尡 ����
	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		//�۾� �����尡 ����
		sumThread.start();
		/*
		try {
			//main �����尡 �۾� �巹���� �Ϸ�ɶ����� �Ͻ� �����·� �ִ´�
			sumThread.join();
		} catch (InterruptedException e) {
		}
		*/
		System.out.println("1~100 ��: " + sumThread.getSum());
	}
}

