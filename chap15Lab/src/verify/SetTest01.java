package verify;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n;
		Set s = new HashSet();
//		TreeSet s = new TreeSet();
		
		Random r = new Random();		
		
		while(true){
			n = r.nextInt(45)+1; // 1 ~ 45 난수 발생
			s.add(n);
			if(s.size() == 6){
				System.out.println(s);
				break;
			}
		}
	}

}
