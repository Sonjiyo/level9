package ploy_game;

import java.util.Random;
import java.util.Scanner;

public class Util {
	private static Scanner sc = new Scanner(System.in);
	private static Random rd = new Random();
	
	private Util() {}
	
	public static int getValue(String msg, int start, int end) {
		while(true) {
			try {
				System.out.print("%s (%d~%d) : ".formatted(msg,start,end));
				int sel = sc.nextInt();
				if(sel<start || sel>end) {
					System.out.println("범위 오류");
					continue;
				}
				System.out.println();
				return sel;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("입력 오류");
			}
		}
	}
	
	public static String getValue(String msg) {
		System.out.print(msg+" : ");
		String input = sc.next();
		return input;
	}

	public static int getRandomNum(int start, int cnt) {
		return rd.nextInt(cnt)+start;
	}
}
