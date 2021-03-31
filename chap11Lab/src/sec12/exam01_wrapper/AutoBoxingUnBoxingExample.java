package sec12.exam01_wrapper;

public class AutoBoxingUnBoxingExample {

	public static void main(String[] args) {
		
		//Auto-boxing
		Integer obj=100;
		System.out.println("value:"+obj.intValue());
		
		//Auto-unboxing
		int value=obj;
		System.out.println("value:"+value);
		
		//¿¬»ê½Ã auto-unboxing
		int result=obj+100;
		System.out.println(result);
		
	}

}
