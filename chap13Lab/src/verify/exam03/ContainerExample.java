package verify.exam03;

public class ContainerExample {

	public static void main(String[] args) {
		Container<String, String> container1 = new Container<String, String>();
		container1.set("È«±æµ¿", "µµÀû");
		String name1 = container1.getKey();
		String job = container1.getValue();
		System.out.println(name1);
		System.out.println(job);
		Container<String, Integer> container2 = new Container<String, Integer>();
		container2.set("È«±æµ¿", 35);
		String name2 = container2.getKey();
		int age = container2.getValue();
		System.out.println(name2);
		System.out.println(age);

	}

}
