package ch6;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest2 {

	public static void main(String[] args) throws FileNotFoundException {

		// FileOutputStream​(File file, boolean append) >> 
		//  If the second argument is true, then bytes will be written to the end of the file rather than the beginning
		FileOutputStream fos = new FileOutputStream("output2.txt", true);
		
		try(fos){
			
			byte[] bs = new byte[26];
			byte data = 65;
			for(int i=0; i<bs.length; i++) {
				bs[i] = data;
				data++;
			}
			
			fos.write(bs, 2, 10); // >> bs[2]부터 10개만 쓰겠다
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("end");
	}

}
