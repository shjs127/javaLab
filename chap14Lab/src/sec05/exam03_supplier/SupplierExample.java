package sec05.exam03_supplier;

import java.util.function.IntSupplier;

public class SupplierExample {
	public static void main(String[] args) {
		//劳疙 备泅 按眉
		IntSupplier intSupplier=new IntSupplier() {
			@Override
			public int getAsInt() {
				int num = (int) (Math.random() * 6) + 1;
				return num;
			}
		};
		/*
		IntSupplier intSupplier = () -> {
			int num = (int) (Math.random() * 6) + 1;
			return num;
		};
		*/
		int num = intSupplier.getAsInt();
		System.out.println("传狼 荐: " + num);
	System.out.println(intSupplier.getAsInt());
	}
}
