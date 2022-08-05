package ch3_gamelevel;

public class BeginnerLevel extends PlayerLevel {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("천천히 달림");
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("jump 못함");
		
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("turn 못함");
		
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("초급자입니다.");
		
	}
	
	
	
	
	
}
