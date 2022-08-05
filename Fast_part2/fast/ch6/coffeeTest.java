package ch6;

public class coffeeTest {

	public static void main(String[] args) {

		Coffee etiophia = new etiophia();
		etiophia.brewing();
		
		System.out.println();
		Latte latte = new Latte(etiophia);
		latte.brewing();
		
		System.out.println();
		whippedCream creamLatte = new whippedCream(latte);
		creamLatte.brewing();
	}

}
