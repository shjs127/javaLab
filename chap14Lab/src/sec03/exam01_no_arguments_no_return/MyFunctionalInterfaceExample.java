package sec03.exam01_no_arguments_no_return;

public class MyFunctionalInterfaceExample { 
	public static void main(String[] args) {
		MyFunctionalInterface fi;
		//익명구현객체
	
		fi=new MyFunctionalInterface() {
			@Override
			public void method() {
				String str="method call1";
				System.out.println(str);
			}
		};
		
		//익명구현 객체->람다식
		fi= () -> { 
			String str = "method call1";
			System.out.println(str);
		};
		fi.method();
		
		fi = () -> { System.out.println("method call2"); };
		fi.method();
		
		fi = () -> System.out.println("method call3");
		fi.method();
	}
}











