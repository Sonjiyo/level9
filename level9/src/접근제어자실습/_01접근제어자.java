package 접근제어자실습;

import 상속_개념.AccessTest;

class Child extends AccessTest{
	Child(){
		a = 10;
		b = 10; // b는 자식 객체라서 내부에서는 접근 가능
		//c = 10;
		//d = 10;
	}
	
	//@Override
	//void printAll() {} => final 메서드는 자식 클래스에서 재정의 불가능
}

public class _01접근제어자 {
	public static void main(String[] args) {
		Child c = new Child();
		
		c.a = 100;
		//c.b = 10; Main 이라는 클래스는 AccessTest를 상속받지 않아서 사용 불가
		//child 각체 자체는 Main 다른 패키지 안에 있기 때문에 접근 불가능
		AccessTest e = new AccessTest();
		e.a = 100;
	}
}
