package 상속_개념;

import java.util.Random;

abstract class Shape{
	String name;
	String color;
	double size;
	abstract void draw();
	
	public Shape(String name, String color, double size) {
		super();
		this.name = name;
		this.color = color;
		this.size = size;
	}
	
	@Override
	public String toString() {
		return "%s %s (%.2f)".formatted(color,name,size);
	}
}

class Line extends Shape{
	
	public Line(String name, String color, double size) {
		super(name, color, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw() {
		System.out.println("선을 긋는다");
	}
}

class Circle extends Shape{
	int radius;
	public Circle(String name, String color, double size, int radius) {
		super(name, color, size);
		this.radius = radius;
	}
	
	@Override
	void draw() {
		System.out.println("원을 그린다");
	}
}

class Point extends Shape{
	
	public Point(String name, String color, double size) {
		super(name, color, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	void draw() {
		System.out.println("점을 찍는다");
	}
}

class Rect extends Shape{
	int height;
	int width;
	
	public Rect(String name, String color, double size, int height, int width) {
		super(name, color, size);
		this.height = height;
		this.width = width;
	}
	
	@Override
	void draw() {
		System.out.println("사각형을 그린다");
	}
}

class Triangle extends Shape{
	int height;
	int width;
	
	public Triangle(String name, String color, double size, int height, int width) {
		super(name, color, size);
		this.height = height;
		this.width = width;
	}
	
	@Override
	void draw() {
		System.out.println("삼각형을 그린다");
	}
}

public class _08다형성 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		//모양, 색깔, 사이즈 랜덤하게 해서 도형 10개 출력
		//점, 선 : 기존 size 출력
		// 그 외 : size = 넓이 넣어서 출력
		
		String[] color = {"파란색", "빨간색", "보라색", "노란색", "분홍색"};
		
		Rect[] menolist = new Rect[2]; //Rect 클래스만 올 수 있다.
		
		Shape[] list = new Shape[10];
		for(int i =0; i<list.length; i++) {
			int rdIdx = rd.nextInt(color.length);
			int rdNum = rd.nextInt(10);
			
		}
	}
}
