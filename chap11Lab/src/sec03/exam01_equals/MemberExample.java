package sec03.exam01_equals;

public class MemberExample {

	public static void main(String[] args) {
		Member obj1=new Member("blue");
		Member obj2=new Member("blue");
		Member obj3=new Member("red");
		
		if(obj1.equals(obj2)) {
			System.out.println("obj1,2�� �����մϴ�.");
		}else {
			System.out.println("obj1,2�� �������� �ʽ��ϴ�.");
		}
		if(obj1 == obj2) {
			System.out.println("obj1,2�� �����մϴ�.");
		}else {
			System.out.println("obj1,2�� �������� �ʽ��ϴ�.");
		}

	}

}
