package ch6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {

	public static void main(String[] args) throws IOException {

		RandomAccessFile rf = new RandomAccessFile("random.txt", "rw");
		rf.writeInt(100);
		System.out.println("파일 포인터 위치:" + rf.getFilePointer()); //int 4byte라 4
		rf.writeDouble(3.14); // double : 8byte
		System.out.println("파일 포인터 위치:" + rf.getFilePointer()); // 4+8 , 12
		rf.writeUTF("안녕하세요"); // 한글은 3byte씩 15 + 끝에 null 2byte
		System.out.println("파일 포인터 위치:" + rf.getFilePointer()); //12+17 =29
	
		rf.seek(0); // 다시 맨앞으로 가라
		System.out.println("파일 포인터 위치:" + rf.getFilePointer());
		
		int i = rf.readInt();
		double d = rf.readDouble();
		String str = rf.readUTF();
	
		System.out.println("파일 포인터 위치:" + rf.getFilePointer());
		System.out.println(i);
		System.out.println(d);
		System.out.println(str);
	}

}
