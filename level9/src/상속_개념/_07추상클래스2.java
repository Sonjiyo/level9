package 상속_개념;

public class _07추상클래스2 {
	public static void main(String[] args) {
		
		//upcasting : 자식 객체가 부모 클래스 타입을 가지는 것
		
		Parent p = new Parent();
		
		Child c1 = new Child();
		
		//이미 자식은 부모를 생성하기 때문에 부모 클래스 타입으로 만들 수 있다.
		Parent c2 = new Child();
		
		Parent c3 = (Parent)c1;
		
		//부모는 자식을 생성하지 않기 때문에 자식타입으로 선언 불가능
		//Child p2 = new Parent(); 오류 
				
		//downcasting : 부모타입 => 자식타입으로 변경
		
		Child c4 = (Child)c2;
	}
}
