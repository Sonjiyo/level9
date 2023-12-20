package _09컬렉션프레임워크;

import java.util.*;

public class _07iterator {
	public static void main(String[] args) {
		
		Set<Integer> list = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		
		//list.remove(3);
		
		for(Integer num : list) {
//			if(num%3==0) {
//				list.remove(num);
//			}
			
			System.out.print(num+ " ");
		}
		
		//인덱스가 존재하지 않기 때문에 사용 불가능
//		for(int i =0; i<list.size(); i++) {
//			
//		}
		System.out.println("\n-----------");
		Iterator<Integer> itor = list.iterator();
		
		System.out.println(itor.next());
		System.out.println(itor.next()); //itor.next() 값을 하나씩 꺼내옴
		
		itor = list.iterator(); //다시 처음부터 초기화
		
		while(itor.hasNext()) {
			if(itor.next()==3) {
				itor.remove();
			}
		}
		System.out.println("-----------");
		for(Integer num : list) {
			System.out.print(num+" ");
		}
		System.out.println("\n-----------");
		Map<Integer, String> list2 = new HashMap<>();
		
		list2.put(1, "1");
		list2.put(2, "2");
		list2.put(3, "3");
		list2.put(4, "4");
		list2.put(5, "5");
		list2.put(6, "6");
		
		Iterator<Integer> itor2 = list2.keySet().iterator();
		Iterator<String> itor3= list2.values().iterator();

		while(itor2.hasNext()) {
			if(itor2.next()==2) itor2.remove();
			//System.out.print(itor2.next()+" ");
		}
		System.out.println();
//		while(itor3.hasNext()) {
//			System.out.print(itor3.next()+" ");
//		}
		System.out.println("\n-----------");
		
		for(Integer key : list2.keySet()) {
			System.out.println(key + " "+list2.get(key));
		}
	}
}
