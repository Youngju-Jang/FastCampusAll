package ch6;

public class whippedCream extends Decorator{

	public whippedCream(Coffee coffee) {
		super(coffee);
	}

	@Override
	public void brewing() {
		// TODO Auto-generated method stub
		super.brewing();
		System.out.print("Adding WhippedCream ");
	}

	
}
