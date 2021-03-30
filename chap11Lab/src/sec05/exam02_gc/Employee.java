package sec05.exam02_gc;

public class Employee {
//필드
	public int eno;
	//생성자
	public Employee(int eno) {
		this.eno=eno;
		System.out.println("employee<"+eno+")가 메모리에 생성됨");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("employee<"+eno+")가 메모리에 제거됨");
	}
	
	
}
