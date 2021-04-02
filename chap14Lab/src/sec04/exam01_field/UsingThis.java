package sec04.exam01_field;

public class UsingThis {
	public int outterField = 10;

	//인스턴스 멤버 클래스
	class Inner {
		int innerField = 20;

		void method() {
			//람다식
			MyFunctionalInterface fi= () -> {
				System.out.println("outterField: " + outterField);
				System.out.println("outterField: " + UsingThis.this.outterField + "\n");
				
				System.out.println("innerField: " + innerField);
				System.out.println("innerField: " + this.innerField + "\n");
			};
			fi.method();
		}
	}
}

