package verify.exam09;

import java.util.HashMap;
import java.util.*;
import java.util.Map;
import java.util.Set;

public class MapExample {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		String name = null;
		int maxScore = 0;
		int totalScore = 0;
		// #1 작성 위치
		int avg=0;
		/*
		Set<String> keyset=map.keySet();
		Iterator<String> keyiterator=keyset.iterator();
		while (keyiterator.hasNext()) {
			String key=keyiterator.next();
			Integer value=map.get(key);
			totalScore+=value;
			if(maxScore<value) {
				maxScore=value;
			}
			if(maxScore==value) {
				name=key;
			}
		}
		avg=totalScore/map.size();	
		System.out.println("평균점수 : "+avg);
		System.out.println("최고점수 : " +maxScore);
		System.out.println("최고점수를 받은 아이디 : "+name);
		*/
		Set<Map.Entry<String, Integer>> set=map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator=set.iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry=iterator.next();
			String key=entry.getKey();
			Integer value=entry.getValue();
			totalScore+=value;
			if(maxScore<value) {
				maxScore=value;
				name=key;
			}
		}
		avg=totalScore/map.size();	
		System.out.println("평균점수 : "+avg);
		System.out.println("최고점수 : " +maxScore);
		System.out.println("최고점수를 받은 아이디 : "+name);
		}

}
//실행 결과
//평균점수: 91
//최고점수: 96
//최고점수를 받은 아이디: blue
//평균 점수를 출력하고, 최고 점수와 최고 점수를 받은 아이디를 출력
