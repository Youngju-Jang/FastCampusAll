package ch6;

public class Latte extends Decorator{

	public Latte(Coffee coffee) {
		super(coffee);		
	}

	@Override
	public void brewing() {
		// TODO Auto-generated method stub
		super.brewing();
		System.out.print("Adding Milk ");
	}
	
	
	
	
}
