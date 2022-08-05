package ch6;

import java.io.IOException;
import java.io.InputStreamReader;

public class SystemInTest1 {

	public static void main(String[] args) {
		
		System.out.println("알파벳 하나를 쓰고 [Enter]를 누르세요");
		
		int i;
		
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			while((i = isr.read())!= '\n') {
				//System.out.println(i);
				System.out.print((char)i);				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
