package ch3_gamelevel;

public class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("빨리 달림");
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("jump 높이함");
		
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("turn 못함");
		
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("중급자입니다.");
		
	}
	
	

}
