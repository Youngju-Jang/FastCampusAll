package backJune;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int y = Integer.parseInt(br.readLine());
		if(y==1) {
			System.out.println(1);
		}else {
			y = (y-2)/6;
			for(int x=0; ; x++)
			if(x*(x+1) == 2*y) {
				System.out.println(x+2);
				break;
			}else if(x*(x+1) > 2*y) {
				System.out.println(x+1);
				break;
			}
		}		
	}
}

