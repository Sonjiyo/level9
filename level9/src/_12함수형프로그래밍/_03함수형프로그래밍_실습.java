package _12함수형프로그래밍;

import java.util.function.BinaryOperator;

@FunctionalInterface
interface GetResult{
	int result(int a,int b);
}


public class _03함수형프로그래밍_실습 {
	public static void main(String[] args) {
		GetResult add =  (a, b)->a+b;
		GetResult subtraact = (a, b)->a-b;
		GetResult multiply = (int a, int b)->a*b;
		
		System.out.println(add.result(10,20));
		System.out.println(subtraact.result(10, 20));
		System.out.println(multiply.result(10, 20));
		
		BinaryOperator<Integer> add2 = (a,b)->a+b;
		
		System.out.println(add2.apply(10, 20));
	}
}
