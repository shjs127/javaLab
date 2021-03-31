package sec14.exam02_calander;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarExample {

	public static void main(String[] args) {

		Calendar now=Calendar.getInstance();
		Calendar now2=new GregorianCalendar();  //자동형변환
		
		int year=now.get(Calendar.YEAR);
		int month=now.get(Calendar.MONDAY)+1;
		int day=now.get(Calendar.DAY_OF_MONTH);
		int week=now.get(Calendar.DAY_OF_WEEK);
		System.out.println(month);
		
		String strWeek=null;
		switch(week) {
		case Calendar.MONDAY:
		strWeek="월";
		break;
		case Calendar.THURSDAY:
		strWeek="화";
		break;
		case Calendar.WEDNESDAY:
		strWeek="수";
		break;
		case Calendar.TUESDAY:
		strWeek="목";
		break;
		case Calendar.FRIDAY:
		strWeek="금";
		break;
		case Calendar.SATURDAY:
		strWeek="토";
		break;
		case Calendar.SUNDAY:
		strWeek="일";
		break;
		}

		int ampm=now.get(Calendar.AM_PM);
		String strampm=null;
		if(ampm==Calendar.AM) {
			strampm="오전";
		}else {
			strampm="오후";
		}
		int hour=now.get(Calendar.HOUR);
		int minute=now.get(Calendar.MINUTE);
		int second=now.get(Calendar.SECOND);
		System.out.print(year+"년 ");
		System.out.print(month+"월 ");
		System.out.print(day+"일 ");
		System.out.print(strWeek+"요일 ");
		System.out.print(strampm+" ");
		System.out.print(hour+"시 ");
		System.out.print(minute+"분 ");
		System.out.print(second+"초 ");
		
		
	}

}
