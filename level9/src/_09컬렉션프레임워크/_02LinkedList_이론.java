package _09컬렉션프레임워크;

import java.util.*;

public class _02LinkedList_이론 {
	public static void main(String[] args) {
		
		//보통 실무에서 타입은 인터페이스로 한다
		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(10);
		list1.add(20);
		list1.add(30);
		list1.add(40);
		
		//부모 타입이기 때문에 값 변경에 유연성이 있다.
		list1 = new LinkedList<Integer>();
		
		LinkedList<Integer> list2 = new LinkedList<Integer>(Arrays.asList(10,20,30,40,50));
		
		//링크드 리스트 안에 스텍이 구현되어 있다.
		//스텍 : 가장 처음에 들어간게 가장 마지막에 나온다
		
		LinkedList<Character> list3 = new LinkedList<Character>();
		list3.push('a');
		list3.push('b');
		list3.push('c');
		list3.push('d');
		list3.push('e');
		
		System.out.println(list3);
		
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		System.out.println(list3.pop());
		
		System.out.println(list3);
		
	}
}
