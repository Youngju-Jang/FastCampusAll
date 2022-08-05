package ProjectOOP;

import java.io.FileWriter;
import java.io.IOException;

public class OthersOOP {

	public static void main(String[] args) throws IOException {
		FileWriter f1 = new FileWriter("data.txt");
		f1.write("Hellow");
		f1.write(" Java");                          
		f1.close();
	}

}
