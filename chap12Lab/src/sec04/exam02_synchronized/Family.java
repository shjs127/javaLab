package sec04.exam02_synchronized;

// Thread 클래스를 상속받아 Thread를 정의함.

public class Family extends Thread {
	Toilet toilet;
	String who;
	boolean key; // 초기값: false

	// 생성자
	public Family(String name, Toilet t) {
		who = name;
		toilet = t;
	}

	public void run() {
		toilet.openDoor(who, key);
	}
}