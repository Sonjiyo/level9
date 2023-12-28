package _15쓰레드;

import java.util.Scanner;

class SingASong implements Runnable{
	int max;
	
	public SingASong(int max) {
		super();
		this.max = max;
	}
	
	@Override
	public void run() {
		String lyric="%s : %d + %d는 귀여미";
		
		for(int i=1; i<=max; i++) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				System.out.println("죄송합니다");
				return;
			}
			System.out.println(lyric.formatted(Thread.currentThread().getName(),i,i));
		}
	}
}

public class _04쓰레드이론04 {
	public static void main(String[] args) {
		
		Thread sing = new Thread(new SingASong(10));
		sing.setName("귀여미송");
		
		sing.start();
		
		try(Scanner sc = new Scanner(System.in)){
			while(sc.hasNext()) {
				String command = sc.nextLine();
				System.out.println(command);
				if(command.equals("check")) {
					System.out.println("노래 끝났니?");
					System.out.println(sing.isAlive() ? "아니" : "응 끝났어");
				}
				
				if(command.equals("stop")) {
					System.out.println("시끄러워");
					sing.interrupt();
					//멈추는 다른 명령어
//					sing.stop();
//					sing.suspend();
//					sing.resume();
				}
				
				if(command.equals("join")) {
					System.out.println("나도 껴줘");
					try {
						sing.join(3000); //비동기를 동기로 만들어줌 / 시간 지정 가능
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
