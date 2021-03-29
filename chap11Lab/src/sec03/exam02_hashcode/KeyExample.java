package sec03.exam02_hashcode;

import java.util.HashMap;

public class KeyExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Key 객체를 식별키로 사용하여 String 값을 저장하는 hashmap객체구성
		//자료구조{key.value)
		
		HashMap<Key,String >hashMap =new HashMap<Key, String>();
		hashMap.put(new Key(1), "홍길동");
		
		String value=hashMap.get(new Key(1));
		System.out.println(value);

	}

}
