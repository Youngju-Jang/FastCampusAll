package ch6;

class Mythread implements Runnable {

	@Override
	public void run() {		
		int i;
		for(i=1; i<=200; i++) {
			System.out.print(i + "\t");
		}
	}
	
}
public class ThreadTest2 {

	public static void main(String args[]) {
		
		System.out.println(Thread.currentThread() + "start");		
		
		MyThread runnable = new MyThread();
		Thread th1 = new Thread(runnable);
		Thread th2 = new Thread(runnable);
		
		th1.start();
		th2.start();		
		
		System.out.println( Thread.currentThread() + "end");
		// 돌아가는 스레드 총 수 : 3개 main, th1, th2
		
		//간단하게 돌릴땐 이렇게써도 됨
		Runnable run = new Runnable() { //익명이너클래스

			@Override
			public void run() {
				System.out.println("run");
			}
			
		};
		run.run();
	}
}
