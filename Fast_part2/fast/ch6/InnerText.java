package ch6;

class OutClass{
	//https://gitlab.com/Youngju-Jang/javacoursework/-/tree/master/Chapter6/6-01
	
	private int num = 10;
	private static int sNum = 20;
	private InClass inClass;
	///
	public OutClass() {
		inClass = new InClass();
	}
	
	private class InClass{
		
		int iNum = 100;				
		// 여기선 static변수 사용볼가함. 언제든 사용할수있는게 static. 이너클래스는 아우터클래스생성된후 활용되기때문
		
		void inTest() {
			System.out.println("OutClass num = " +num + "(외부 클래스의 인스턴스 변수)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수)");
			System.out.println("InClass inNum = " + iNum + "(내부 클래스의 인스턴스 변수)");

		}
	}
	
	public void usingClass() {
		inClass.inTest();
	}
	
	static class InStaticClass{
		
		int inNum = 100;
		static int sInNum = 200;
		
		void inTest() {
			//num += 10;    // 외부 클래스의 인스턴스 변수는 사용할 수 없음.
			System.out.println("InStaticClass inNum = " + inNum + "(내부 클래스의 인스턴스 변수 사용)"); 
			System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수 사용)");

		}
		
		static void sTest() {
			//num += 10;   // 외부 클래스의 인스턴스 변수는 사용할 수 없음.
			//inNum += 10; // 내부 클래스의 인스턴스 변수는 사용할 수 없음
			
			System.out.println("OutClass sNum = " + sNum + "(외부 클래스의 스태틱 변수 사용)");
			System.out.println("InStaticClass sInNum = " + sInNum + "(내부 클래스의 스태틱 변수 사용)");
			
		}				
	}
}

public class InnerText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OutClass outClass = new OutClass();
		outClass.usingClass();
		
		System.out.println();
		
		// OutClass.InClass inner = outClass.new InClass();
		// inner.inTest();
		
		OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
		sInClass.inTest();
		System.out.println();
		
		OutClass.InStaticClass.sTest();
	}

}
