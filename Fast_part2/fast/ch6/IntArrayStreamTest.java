package ch6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5};
		
		for( int num : arr) {
			System.out.print(num);
		}
		System.out.println();
		Arrays.stream(arr).forEach(n -> System.out.print(n));
		
		IntStream is = Arrays.stream(arr);
		is.forEach(n -> System.out.print(n));
		// is. >> 함수주루룩
		
		int sum = Arrays.stream(arr).sum();
		System.out.println(sum);
	}

}
