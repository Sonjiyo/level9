package 접근제어자실습;

final class Test{
	int num1;
	int num2;
	
	public Test(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}

	@Override
	public String toString() {
		return "Test [num1=" + num1 + ", num2=" + num2 + "]";
	}
}

//class Test2 extends Test{} //final 클래스는 부모로 만들 수 없다

public class _02파이널테스트 {
	public static void main(String[] args) {
		
		final Test t = new Test(10, 20); //주소값 고정
		
		System.out.println(t);
		
		//t = new Test(100,200); 주소 자체는 변경 불가능
		
		t.num1 = 100;
		t.num2 = 200;
		System.out.println(t);
		
	}
}
