package sec03.exam02_hashcode;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Key ��ü�� �ĺ�Ű�� ����Ͽ� String ���� �����ϴ� hashmap��ü����
		//�ڷᱸ��{key.value)
		
		HashMap<Key,String >hashMap =new HashMap<Key, String>();
		hashMap.put(new Key(1), "ȫ�浿");
		
		String value=hashMap.get(new Key(1));
		System.out.println(value);

	}

}
