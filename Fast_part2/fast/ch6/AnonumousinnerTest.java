// https://gitlab.com/Youngju-Jang/javacoursework/-/tree/master/Chapter6/6-01
package ch6;

class Outer2{
	
	int outNum = 100;
	static int sNum = 200;
	
	Runnable getRunnable(int i) {  // 메서드 호출 이후에도 사용해야 하는 경우가 있을 수 있으므로 지역 내부 클래스에서 사용하는 메서드의 지역 변수나 매개 변수는 final로 선언됨
		//지역 내부 클래스 //메서드 내부에서 정의하여 사용하는 클래스
		int num = 10;
		
		//class MyRunnable implements Runnable{  >> MyRunnable: 메서드안에서밖에 안쓰이는 클래스라 이름줄필요 없음 
		return new Runnable() { // > 익명내부클래스 
			int localNum = 1000;

			@Override
			public void run() {
				
				System.out.println("i =" + i); 
				System.out.println("num = " +num);  
				System.out.println("localNum = " +localNum);
					
				System.out.println("outNum = " + outNum + "(외부 클래스 인스턴스 변수)");
				System.out.println("Outter.sNum = " + Outer2.sNum + "(외부 클래스 정적 변수)");
			}			
		};	
	}
	Runnable runnable = new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Runnable 이 구현된 익명 클래스 변수");
		}
	};	
}

public class AnonumousinnerTest {

	public static void main(String[] args) {
		
		Outer2 out = new Outer2();
		Runnable runner =  out.getRunnable(100);
		
		runner.run();
		
		out.runnable.run();
	}

}
