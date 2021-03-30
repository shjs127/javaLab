package sec06.exam01_class;

public class ClassExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car=new Car();
		Class clazz1=car.getClass();
		System.out.println(clazz1.getName());    //��ü.getclass�� class ��ü�� ��´�
		System.out.println(clazz1.getSimpleName());
		System.out.println(clazz1.getPackage().getName());
		System.out.println();
		
		try {
			//class.forname �� �ش簴ü�� Ŭ������ ��´�.
			Class clazz2=Class.forName("sec06.exam01_class.Car");
			System.out.println(clazz2.getName());    
			System.out.println(clazz2.getSimpleName());
			System.out.println(clazz2.getPackage().getName());
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
