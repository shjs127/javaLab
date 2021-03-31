package sec13.exam01_math;

public class MathExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v1=Math.abs(-5);
		double v2=Math.abs(-3.14);
		System.out.println("v1="+v1);
		System.out.println("v2="+v2);
		
		double v3=Math.ceil(5.3);
		double v4=Math.ceil(-5.3);
		System.out.println("v3="+v3);
		System.out.println("v4="+v4);
		
		double v5=Math.floor(5.3);
		double v6=Math.floor(-5.3);
		System.out.println("v5="+v5);
		System.out.println("v6="+v6);
		
		double v11=Math.random();
		System.out.println("v11="+v11);
		
		long v14=Math.round(5.3);
		long v15=Math.round(5.7);
		System.out.println("v14="+v14);
		System.out.println("v15="+v15);
		
		
	}

}
