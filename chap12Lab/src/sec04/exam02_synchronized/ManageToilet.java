package sec04.exam02_synchronized;

// 5개의 Thread를 만들어 실행 시키는 클래스

public class ManageToilet {

    public static void main( String[] args ) {
		Toilet t = new Toilet();

		// thread 생성
		Family father = new Family("아버지", t );
		Family mother = new Family("어머니", t );
		Family sister = new Family("누나", t );
		Family brother = new Family("형", t );
		Family me = new Family("나", t );

/*** 우선 순위 적용안됨
		father.setPriority(10);
		mother.setPriority(7);
		sister.setPriority(5);
		brother.setPriority(3);
		me.setPriority(1);
*/

		// 각 Thread는 Runnable 상태에 들어감
		father.start();
		mother.start();
		sister.start();
		brother.start();
		me.start();
    }
}