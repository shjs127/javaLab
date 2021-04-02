package verity.exam04;

import java.util.function.IntSupplier;

public class LambdaExample {

	public static void main(String[] args) {
		System.out.println(method(3,5));

	}
	public static int method(int x, int y) {
		IntSupplier supplier = () -> {
	//	x *= 10;
		int result = x + y;
		return result;
		};
		int result = supplier.getAsInt();
		return result;
		}

}
