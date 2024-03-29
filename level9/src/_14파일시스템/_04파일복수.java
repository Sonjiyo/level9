package _14파일시스템;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class _04파일복수 {
	
	public static void copyFiles(String from, String newFileName) {
		Path fromPath = Paths.get(from);
		Path toPath = fromPath.getParent().resolve(Paths.get(newFileName));
		
		try {
			Files.copy(fromPath, toPath);
			System.out.println("파일 복사 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		String FileName = "background.jpeg";
		String imgPath = "src\\_14파일시스템\\"+FileName;
		copyFiles(imgPath, "new_"+FileName);
		
	}
}
