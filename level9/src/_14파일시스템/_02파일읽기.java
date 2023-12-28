package _14파일시스템;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class _02파일읽기 {
	public static void main(String[] args) {
		
		String path = "src\\"+_02파일읽기.class.getPackageName();
		Path txtPath = Paths.get(path, "test.txt");
		System.out.println(Files.exists(txtPath));
		
		List<String> lines = Arrays.asList("테스트 문자입니다.","띄어지는 지 확인합니다.","여러문장입니다.");
		try {
			Files.write(txtPath, lines);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] path4Bytes = null;
		//대용량 파일 경우 부적합
		try {
			path4Bytes = Files.readAllBytes(txtPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String result = new String(path4Bytes);
		System.out.println(result);
		
		//파일 복사
		Path copid = Paths.get(txtPath.getParent().toString(),"moved.txt");
		try {
			Files.copy(txtPath, copid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//파일 이동
		Path moved = Paths.get(txtPath.getParent().getParent().toString(),"moved.txt");
		
		try {
			Files.move(copid, moved);
			System.out.println("이동 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Files.delete(moved);
			System.out.println("삭제 완료");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
