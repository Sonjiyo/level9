package _12함수형프로그래밍;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _05스트림_이론 {
	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("박연미","유재석","하하","정형돈","노홍철","박연미","하하");
		
		System.out.println("=======1=======");
		for(int i =0; i<names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		System.out.println("=======2=======");
		for(String l : names) {
			System.out.println(l);
		}
		
		System.out.println("=======3=======");
		names.forEach(System.out::println);
		
		System.out.println("=======4======");
		Stream<String> nameStream = names.stream(); //리스트 names에 스트림 객체 생성
		
		nameStream.forEach(System.out::println); //이미 최종연산이 끝나면 스트림객체 .close()
		
		//최종 연산은 마지막에 한 번만 사용할 수 있다.
		//nameStream.count(); //stream has already been operated upon or closed
		
		System.out.println("=======5======");
		//메소드 제어닝
		names.stream().distinct().forEach(System.out::println); //중복제거
		
		System.out.println("=======6======");
		List<String> nameList = names.stream()
								.filter(name->name.equals("박연미"))
								.collect(Collectors.toList());
		
		System.out.println(nameList);
		
		List<Integer> list = new ArrayList<>(Arrays.asList(5,2,0,8,4,1,7,9,3,6));
		
		String result = list.stream()
						.filter(num->num%2==1)
						.sorted(Integer::compare)
						.map(num->num+"")
						.collect(Collectors.joining(", "));
		
		System.out.println(result);
		
//		for(int i=0; i<list.size(); i++) {
//			if(list.get(i)%2!=1) {
//				list.remove(i);
//				i-=1;
//			}
//		}
//		Collections.sort(list);
//		for(int i =0; i<list.size(); i++) {
//			System.out.print(i==0? list.get(i) : ", "+list.get(i));
//		}
	}
}
