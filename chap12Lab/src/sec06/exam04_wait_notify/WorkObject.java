package sec06.exam04_wait_notify;

public class WorkObject {
	public synchronized void methodA() {
		System.out.println("ThreadA�� methodA() �۾� ����");
		notify();   //�ٸ� �Ͻ����������� �����忡�� runnable���·� �����
		try {
			wait();  //�ڽ� �����带 �Ͻ����� ���·� �����
		} catch (InterruptedException e) {
		}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB�� methodB() �۾� ����");
		notify();
		try {
			wait();
		} catch (InterruptedException e) {
		}
	}
}
