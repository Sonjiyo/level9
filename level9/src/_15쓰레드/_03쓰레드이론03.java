package _15쓰레드;

class TestThread implements Runnable{
	int no;
	public TestThread(int no) {
		this.no=no;
	}
	
	@Override
	public void run() {
		System.out.println("쓰레드 이름 : "+Thread.currentThread().getName());

		for(int i =0; i<20; i++) {
			System.out.print(no);
			//시간 지연을 위한 for문
			for(int j=0; j<Integer.MAX_VALUE; j++) {}
		}
	}
}

public class _03쓰레드이론03 {
	public static void main(String[] args) {
		
		Thread test1 = new Thread(new TestThread(1));
		Thread test2 = new Thread(new TestThread(2));
		Thread test3 = new Thread(new TestThread(3));
		
		test1.setName("쓰레드(1)");
		test2.setName("쓰레드(2)");
		test3.setName("쓰레드(3)");
		
		//jvm에서 쓰레드의 우선순위를 권장해줬지만
		//실제 컨트롤하고 있는 건 OS(Window)에서 처리
		//우선 설정을 해놔도 OS는 무시하면 그만 / 큰 기대 하지 말자
		
		//내부적으로 호출 순으로 처리할 수 있게 하는 것만 쓰레드에 우선순위 할당 가능
		
		//우선권은 1~10 높을수록 우선순위가 높다.
		test1.setPriority(Thread.MIN_PRIORITY); //1
		//기본 우선순위는 5다.
		test1.setPriority(Thread.NORM_PRIORITY); //5
		test1.setPriority(Thread.MAX_PRIORITY); //10
		
		test1.start();
		test2.start();
		test3.start();
	}
}
