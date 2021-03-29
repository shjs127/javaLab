package sec03.exam06_finalize;

public class Count {
	private int no;
	
	public Count(int no) {
	this.no =no;
	}

	@Override
	protected void finalize() throws Throwable {
		System.out.println(no+"번 객체의 finalize가 실행");
	}
}
