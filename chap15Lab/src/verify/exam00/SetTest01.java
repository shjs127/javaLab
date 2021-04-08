package verify.exam00;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest01 {

	public static void main(String[] args) {
		int n;
		Set s = new HashSet();
		// TreeSet s = new TreeSet();
		Random r = new Random();
		
		while(s.size()!=6) {
			n=r.nextInt(45)+1;
			s.add(n);
			if(s.size()==6) {
				System.out.println(s);
				break;
			}
		}
/*
		for(int i=0;i<50;i++) {
			s.add(r.nextInt(45)+1);
			if (s.size()==6)
				break;
		}
 */		
	}

}
