package sec03.exam06_finalize;

public class FinalizeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Count counter=null;
		
		for (int i=1;i<=50; i++) {
			counter=new Count(i);
			counter=null;
			System.gc(); //gargage collector를 강제로실행
		}
	}

}
