package ch6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;

public class FileInputStreamTest1 {

	public static void main(String[] args) {
		
		System.out.println(Paths.get("").toAbsolutePath().toString());
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./fast/input.txt");
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
			System.out.println((char)fis.read());
		} catch (IOException e) {
			e.printStackTrace();
			try {
				fis.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (Exception e2) { // null파일을 close할때의 오류캐치
				System.out.println(e2);
			}
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		System.out.println("End");
	}

}
