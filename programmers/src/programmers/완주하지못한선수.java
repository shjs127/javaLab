package programmers;

import java.util.HashMap;
public class 완주하지못한선수 {
	public static void main(String[] args) {
		String[] A = {"leo","kiki","eden"};
		String[] A1 = {"eden", "kiki"};
		
		String[] B = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] B1 = {"josipa", "filipa", "marina", "nikola"};
		
		String[] C = {"mislav", "stanko", "mislav", "ana"};
		String[] C1 = {"stanko", "ana", "mislav"};
		
		String answer = Solution(A, A1);
		System.out.println(answer);
		
		answer = Solution(B, B1);
		System.out.println(answer);
		
		answer = Solution(C, C1);
		System.out.println(answer);
		
	}

	private static String Solution(String[] participant, String[] completion) {
		String answer = "";
	HashMap<String , Integer> hm=new HashMap<>();
	for (String run:participant) hm.put(run, hm.getOrDefault(run, 0)+1);
	for (String run:completion) hm.put(run, hm.getOrDefault(run, 0)-1);
	for(String run:hm.keySet())
		if(hm.get(run)!=0)
			answer=run;
			
	
	return answer;
	}
	
    
}
