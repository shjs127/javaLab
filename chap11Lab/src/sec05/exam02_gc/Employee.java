package sec05.exam02_gc;

public class Employee {
//�ʵ�
	public int eno;
	//������
	public Employee(int eno) {
		this.eno=eno;
		System.out.println("employee<"+eno+")�� �޸𸮿� ������");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("employee<"+eno+")�� �޸𸮿� ���ŵ�");
	}
	
	
}
