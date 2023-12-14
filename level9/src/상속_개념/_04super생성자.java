package 상속_개념;

class Product{
	String name;
	int price;
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
}

class Fruit extends Product{
	String origin;
	
	//초기값이 있는 부모이기 때문에 아래와 같이 만들어야 함
	public Fruit(String name, int price, String origin) {
		super(name, price);
		this.origin = origin;
	}
	
}

public class _04super생성자 {
	public static void main(String[] args) {
		
		Product meat = new Product("고기", 10000);
		Fruit banana = new Fruit("바나나", 2000, "필리핀");
		
	}
}
