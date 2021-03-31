package sec14.exam01_date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		
		Date now=new Date();
		String strnow=now.toString();
		
		System.out.println(now);
		System.out.println(strnow);
		
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		//SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일 a hh:mm:ss");
		String strnow2=sdf.format(now);
		System.out.println(strnow2);
		
		
	}

}
