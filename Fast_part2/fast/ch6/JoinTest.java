package ch6;

public class JoinTest extends Thread{
	
	int start;
	int end;
	int total;
	
	public JoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}
	
	public void run() {
		
		int i;
		for (i=start; i<=end; i++) {			
			total += i;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Thread.currentThread() + "start");
		JoinTest jt1 = new JoinTest(1, 50);
		JoinTest jt2 = new JoinTest(51, 100);
		
		jt1.start();
		jt2.start();
		
		//main이 jt1,2에 join걺 >> main은 수행x 대기
		try {
			jt1.join();
			jt2.join();
		} catch (InterruptedException e) { 
			e.printStackTrace();
		}
		
		int lastTotal = jt1.total + jt2.total;
		
		System.out.println("jt1.total = " + jt1.total);
		System.out.println("jt2.total = " + jt2.total);
		System.out.println("lastTotal = "+lastTotal);
		
		System.out.println(Thread.currentThread() + "end");
	}

}
