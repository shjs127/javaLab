package sec05.exam02_gc;

public class GcExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp;
		emp=new Employee(1);
		emp=null;
		emp=new Employee(2);
		emp= new Employee(3);
		
		System.out.println("emp가 최종적으로 참조하는 사원번호"+emp.eno);
		
		System.gc();

	}

}
