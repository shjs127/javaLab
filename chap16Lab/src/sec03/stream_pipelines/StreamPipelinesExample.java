package sec03.stream_pipelines;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class StreamPipelinesExample {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("ȫ�浿", Member.MALE, 30),
				new Member("�質��", Member.FEMALE, 20),
				new Member("�ſ��", Member.MALE, 45),
				new Member("�ڼ���", Member.FEMALE, 27)
		);
		
		double ageAvg =   list.stream()
			.filter(m -> m.getSex()==Member.MALE)
			/*	.filter(new Predicate<Member>() {

					@Override
					public boolean test(Member m) {
						// TODO Auto-generated method stub
						return m.getSex()==Member.MALE;
					}
					
				})
				*/
			//.mapToInt(Member :: getAge)
			/*
			.mapToInt(new ToIntFunction<Member>() {

				@Override
				public int applyAsInt(Member value) {
					// TODO Auto-generated method stub
					return m.getAge();
				}
				
			})
			*/
			.mapToInt(m->m.getAge())
			.average()
			.getAsDouble();
		
		System.out.println("���� ��� ����: " + ageAvg);
	}
}


