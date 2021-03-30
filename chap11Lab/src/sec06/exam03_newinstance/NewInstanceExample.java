package sec06.exam03_newinstance;

public class NewInstanceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			//Class clazz=Class.forName("sec06.exam03_newinstance.SendAction");
			//Class clazz=Class.forName("sec06.exam03_newinstance.ReceiveAction");
			Class clazz=Class.forName(args[0]);
			Action action=(Action)clazz.newInstance(); //scndaction 备泅 按眉积己
			action.execute();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(InstantiationException e) {
			e.printStackTrace();
		}catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
}
