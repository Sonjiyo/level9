package _11클렉션Member;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
	private static String file_path;
	private static File file;
	private static FileManager instance = new FileManager();
	
	private FileManager(){
		file_path = System.getProperty("user.dir")+"\\src\\"
					+this.getClass().getPackageName()+"\\";
		
	}
	
	public static void fileSave(String data) {
		if(data.isEmpty()) return;
		file = new File(file_path+"memberData.txt");
		
		try(FileWriter fw = new FileWriter(file)){
			fw.write(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String fileLoad() {
		file = new File(file_path+"memberData.txt");
		
		String data = "";
		try(FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);){
			String str = "";
			while(true) {
				str = br.readLine();
				if(str==null) break;
				data+=str+"\n";
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data = data.substring(0,data.length()-1);
		return data;
	}
}
