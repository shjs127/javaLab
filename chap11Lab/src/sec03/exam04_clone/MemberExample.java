package sec03.exam04_clone;

public class MemberExample {

	public static void main(String[] args) {

		Member original=new Member("blue", "ȫ�浿","12345", 25, true);
		
		//���� ��ü�� �����Ŀ� �н����� ����
		Member cloned=original.getMember();
		
		cloned.password="67890";
		
		System.out.println("���� ��ü�� �ʵ尪");
		System.out.println(cloned.name);
		System.out.println(cloned.name);
		System.out.println(cloned.password);
System.out.println(cloned.age);
	System.out.println(cloned.adult);
	System.out.println();
	System.out.println("���� ��ü�� �ʵ尪");
	System.out.println(original.name);
	System.out.println(original.name);
	System.out.println(original.password);
System.out.println(original.age);
System.out.println(original.adult);
		

	}

}
