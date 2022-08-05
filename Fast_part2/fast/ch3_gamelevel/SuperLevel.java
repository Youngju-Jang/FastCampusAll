package ch3_gamelevel;

public class SuperLevel extends PlayerLevel{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("매우 빨리 달림");
		
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("jump 높이함");
		
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("turn 합니다");
		
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("고급자입니다.");
		
	}
}
