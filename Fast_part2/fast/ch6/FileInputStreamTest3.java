package ch6;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest3 {

	public static void main(String[] args) {
		
		int i;
		try(FileInputStream fis = new FileInputStream("./fast/input2.txt")){
			
			byte[] bs = new byte[10];
			
			while((i=fis.read(bs))!= -1) {
				
//				for(int ch : bs) {
//					System.out.print((char)ch);
//				}//  >> 이렇게 하면 버퍼에 남은애들도 다나와버림
				for(int j=0; j<i; j++) {
					System.out.print((char)bs[j]);
				}
				System.out.println(" : " + i + "바이트 읽음");
			}
		}catch(IOException e) {
			
		}
	}

}
