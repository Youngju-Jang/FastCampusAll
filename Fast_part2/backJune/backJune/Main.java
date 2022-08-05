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

	public static int[][] APT = new int[15][15]; //층,호
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = Integer.parseInt(br.readLine());
		int cnt = -1;
		int result;
		
		int max = total/5;
		
		for(int i=0; i<=max; i++) {
			if((total - (i*5))%3 == 0) {
				cnt = (total - (i*5))/3;	
				cnt += i;
			}			
		}
		if(cnt == -1) {
			System.out.println(-1);
		}else {
			System.out.println(cnt);
			}
		System.out.println('a' + '0');		
	}
	
}

