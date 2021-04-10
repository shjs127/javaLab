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
		// #1 �ۼ� ��ġ
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
		System.out.println("������� : "+avg);
		System.out.println("�ְ����� : " +maxScore);
		System.out.println("�ְ������� ���� ���̵� : "+name);
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
		System.out.println("������� : "+avg);
		System.out.println("�ְ����� : " +maxScore);
		System.out.println("�ְ������� ���� ���̵� : "+name);
		}

}
//���� ���
//�������: 91
//�ְ�����: 96
//�ְ������� ���� ���̵�: blue
//��� ������ ����ϰ�, �ְ� ������ �ְ� ������ ���� ���̵� ���
