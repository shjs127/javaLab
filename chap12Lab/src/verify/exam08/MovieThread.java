package verify.exam08;

public class MovieThread extends Thread{

	@Override
	public void run() {
		while(true) {
			System.out.println("½ÇÇà Áß");
			
		
			if(Thread.interrupted()) {
				break;
			}
			
		}
	
		
		
	}
	

}
