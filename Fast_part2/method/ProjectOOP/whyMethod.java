package ProjectOOP;

import java.io.FileWriter;
import java.io.IOException;

public class whyMethod {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String out = twoTimes("A", "_");
		System.out.println(out);
		FileWriter fw = new FileWriter("out.txt");
		fw.write(out);
		fw.close();
		System.out.println(twoTimes("a", "*"));
	}
	
	public static String twoTimes(String text, String delimiter) {
		String out = "";
		out = out + delimiter + "/n";
		out = out + text + "/n";
		out = out + text + "/n";
		return out;	
	}

}
