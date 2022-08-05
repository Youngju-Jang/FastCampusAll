package ch6;

public class PrintStringTest {
	
	// 2.
	public static void showMyString(PrintString p) {		
		p.showString("hello lambda_2");
	}
	
	// 3.
	public static PrintString returnString() {
		return s->System.out.println(s + "world");
	}

	public static void main(String[] args) {

		// 1. 람다식을 변수에 대입
		PrintString lambdaStr = s-> System.out.println(s);
		lambdaStr.showString("hello lambda_1");
		
		// 2. 매개변수로 전달하는 람다식
		showMyString(lambdaStr);
		
		// 3. 반환 값으로 쓰이는 람다식
		
		PrintString reStr = returnString();
		reStr.showString("hello ");
	}

}
